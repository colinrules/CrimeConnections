
package com.crimeconnections.crime.CrimePojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Attributes implements Serializable{

    @SerializedName("OBJECTID")
    @Expose
    private Integer oBJECTID;
    @SerializedName("primary_key")
    @Expose
    private String primaryKey;
    @SerializedName("final_case_type")
    @Expose
    private String finalCaseType;
    @SerializedName("occ_year")
    @Expose
    private Integer occYear;
    @SerializedName("occ_dt")
    @Expose
    private Long occDt;
    @SerializedName("obfAddress")
    @Expose
    private String obfAddress;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("zone")
    @Expose
    private String zone;
    @SerializedName("grid")
    @Expose
    private String grid;
    @SerializedName("how_received")
    @Expose
    private String howReceived;
    @SerializedName("unit_id1")
    @Expose
    private String unitId1;
    @SerializedName("unit_id2")
    @Expose
    private Object unitId2;
    @SerializedName("unit_id3")
    @Expose
    private Object unitId3;
    @SerializedName("report_flag")
    @Expose
    private String reportFlag;
    @SerializedName("case_status")
    @Expose
    private String caseStatus;
    @SerializedName("cleared_by")
    @Expose
    private String clearedBy;
    @SerializedName("x_rand")
    @Expose
    private Integer xRand;
    @SerializedName("y_rand")
    @Expose
    private Integer yRand;
    @SerializedName("disclaimer")
    @Expose
    private String disclaimer;
    @SerializedName("place_name")
    @Expose
    private Object placeName;
    @SerializedName("CFSType")
    @Expose
    private String cFSType;

    public Integer getOBJECTID() {
        return oBJECTID;
    }

    public void setOBJECTID(Integer oBJECTID) {
        this.oBJECTID = oBJECTID;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getFinalCaseType() {
        return finalCaseType;
    }

    public void setFinalCaseType(String finalCaseType) {
        this.finalCaseType = finalCaseType;
    }

    public Integer getOccYear() {
        return occYear;
    }

    public void setOccYear(Integer occYear) {
        this.occYear = occYear;
    }

    public Long getOccDt() {
        return occDt;
    }

    public void setOccDt(Long occDt) {
        this.occDt = occDt;
    }

    public String getObfAddress() {
        return obfAddress;
    }

    public void setObfAddress(String obfAddress) {
        this.obfAddress = obfAddress;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getHowReceived() {
        return howReceived;
    }

    public void setHowReceived(String howReceived) {
        this.howReceived = howReceived;
    }

    public String getUnitId1() {
        return unitId1;
    }

    public void setUnitId1(String unitId1) {
        this.unitId1 = unitId1;
    }

    public Object getUnitId2() {
        return unitId2;
    }

    public void setUnitId2(Object unitId2) {
        this.unitId2 = unitId2;
    }

    public Object getUnitId3() {
        return unitId3;
    }

    public void setUnitId3(Object unitId3) {
        this.unitId3 = unitId3;
    }

    public String getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(String reportFlag) {
        this.reportFlag = reportFlag;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getClearedBy() {
        return clearedBy;
    }

    public void setClearedBy(String clearedBy) {
        this.clearedBy = clearedBy;
    }

    public Integer getXRand() {
        return xRand;
    }

    public void setXRand(Integer xRand) {
        this.xRand = xRand;
    }

    public Integer getYRand() {
        return yRand;
    }

    public void setYRand(Integer yRand) {
        this.yRand = yRand;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Object getPlaceName() {
        return placeName;
    }

    public void setPlaceName(Object placeName) {
        this.placeName = placeName;
    }

    public String getCFSType() {
        return cFSType;
    }

    public void setCFSType(String cFSType) {
        this.cFSType = cFSType;
    }

}
