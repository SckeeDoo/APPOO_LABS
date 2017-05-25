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
    private int ga_adults;
    private int _2010_census_population;

    public void setCw_adults(int cw_adults) {
        this.cw_adults = cw_adults;
    }

    public void setFc_kids(int fc_kids) {
        this.fc_kids = fc_kids;
    }

    public void setKg_kids(int kg_kids) {
        this.kg_kids = kg_kids;
    }

    public void setGa_adults(int ga_adults) {
        this.ga_adults = ga_adults;
    }

    public void set_2010_census_population(int fc_adults) {
        this._2010_census_population = fc_adults;
    }

    public void setCf_adults(int cf_adults) {
        this.cf_adults = cf_adults;
    }

    public int getFc_kids() {
        return fc_kids;
    }

    public int getKg_kids() {
        return kg_kids;
    }

    public int getGa_adults() {
        return ga_adults;
    }

    public int get_2010_census_population() {
        return _2010_census_population;
    }

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
