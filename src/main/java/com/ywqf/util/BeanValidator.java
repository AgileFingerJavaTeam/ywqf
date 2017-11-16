package com.ywqf.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ywqf.exception.ParamException;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * Created by sunzhongyuan on 2017/10/22.
 */
public class BeanValidator {

	private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

	/**
	 * 验证bean的合法性
	 * 
	 * @param t
	 * @param groups
	 * @param <T>
	 * @return
	 */
	public static <T> Map<String, String> validate(T t, Class... groups) {
		Validator validator = validatorFactory.getValidator();
		Set validateResult = validator.validate(t, groups);
		if (validateResult.isEmpty()) {
			return Collections.emptyMap();
		} else {
			LinkedHashMap errors = Maps.newLinkedHashMap();
			Iterator iterator = validateResult.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation violation = (ConstraintViolation) iterator.next();
				errors.put(violation.getPropertyPath().toString(), violation.getMessage());
			}
			return errors;
		}
	}

	/**
	 * 验证bean集合list的合法性
	 * 
	 * @param collection
	 * @return
	 */
	public static Map<String, String> validateList(Collection<?> collection) {
		Preconditions.checkNotNull(collection);
		Iterator iterator = collection.iterator();
		Map errors;
		do {
			if (!iterator.hasNext()) {
				return Collections.emptyMap();
			}
			Object object = iterator.next();
			errors = validate(object, new Class[0]);
		} while (errors.isEmpty());
		return errors;
	}

	/**
	 * 校验任意对象的合法性，整合validate和validateList方法
	 * 
	 * @param first
	 * @param objects
	 * @return
	 */
	public static Map<String, String> validateObject(Object first, Object... objects) {
		if (objects != null && objects.length > 0) {
			return validateList(Lists.asList(first, objects));
		} else {
			return validate(first, new Class[0]);
		}
	}

	/**
	 * 校验参数，抛出异常
	 * 
	 * @param param
	 * @throws ParamException
	 */
	public static void check(Object param) throws ParamException {
		Map<String, String> map = BeanValidator.validateObject(param);
		if (MapUtils.isNotEmpty(map)) {
			throw new ParamException(map.toString());
		}
	}

}