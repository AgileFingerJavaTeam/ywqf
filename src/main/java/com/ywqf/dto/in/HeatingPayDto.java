package com.ywqf.dto.in;

public class HeatingPayDto {
    private int CorpId;
    private int CommunityId;
    private String Search;
    private String Date;

    public int getCorpId() {
        return CorpId;
    }

    public void setCorpId(int corpId) {
        CorpId = corpId;
    }

    public int getCommunityId() {
        return CommunityId;
    }

    public void setCommunityId(int communityId) {
        CommunityId = communityId;
    }

    public String getSearch() {
        return Search;
    }

    public void setSearch(String search) {
        Search = search;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
