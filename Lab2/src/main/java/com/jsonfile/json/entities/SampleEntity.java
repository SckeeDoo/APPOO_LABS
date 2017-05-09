package com.jsonfile.json.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by schiduvasile on 5/8/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SampleEntity {

    private int aa_kids;
    private int cf_kids;
    private int mc_kids;
    private int mc_total;
    private int cw_adults;
    private int fc_kids;
    private int kg_kids;

    public int getCw_adults() {
        return cw_adults;
    }

    public int getCf_adults() {
        return cf_adults;
    }

    private int cf_adults;


    public SampleEntity() {
    }

    public void setMc_total(int mc_total) {
        this.mc_total = mc_total;
    }

    public int getMc_total() {
        return mc_total;
    }

    public int getAa_kids() {
        return aa_kids;
    }

    public int getMc_kids() {
        return mc_kids;
    }

    public void setMc_kids(int mc_kids) {
        this.mc_kids = mc_kids;
    }

    public void setAa_kids(int aa_kids) {
        this.aa_kids = aa_kids;
    }

    public int getCf_kids() {
        return cf_kids;
    }

    public void setCf_kids(int cf_kids) {
        this.cf_kids = cf_kids;
    }
}
