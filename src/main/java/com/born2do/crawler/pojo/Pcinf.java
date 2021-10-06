package com.born2do.crawler.pojo;

import java.io.Serializable;

/**
 * @author chenhy
 * @date 2021/9/2
 */
public class Pcinf implements Serializable {

    private String wbname;
    private String wbsite;
    private String pgaddr;
    private String pcaddr;
    private String mdname;
    private String mdinfo;
    private String artnam;
    private String resolu;
    private String issues;
    private String labels;
    private String introd;
    private String fupath;

    public Pcinf() {
    }

    public Pcinf(String wbname, String wbsite, String pgaddr, String pcaddr, String mdname, String mdinfo, String artnam, String resolu, String issues, String labels, String introd, String fupath) {
        this.wbname = wbname;
        this.wbsite = wbsite;
        this.pgaddr = pgaddr;
        this.pcaddr = pcaddr;
        this.mdname = mdname;
        this.mdinfo = mdinfo;
        this.artnam = artnam;
        this.resolu = resolu;
        this.issues = issues;
        this.labels = labels;
        this.introd = introd;
        this.fupath = fupath;
    }

    public String getWbname() {
        return wbname;
    }

    public void setWbname(String wbname) {
        this.wbname = wbname;
    }

    public String getWbsite() {
        return wbsite;
    }

    public void setWbsite(String wbsite) {
        this.wbsite = wbsite;
    }

    public String getPgaddr() {
        return pgaddr;
    }

    public void setPgaddr(String pgaddr) {
        this.pgaddr = pgaddr;
    }

    public String getPcaddr() {
        return pcaddr;
    }

    public void setPcaddr(String pcaddr) {
        this.pcaddr = pcaddr;
    }

    public String getMdname() {
        return mdname;
    }

    public void setMdname(String mdname) {
        this.mdname = mdname;
    }

    public String getMdinfo() {
        return mdinfo;
    }

    public void setMdinfo(String mdinfo) {
        this.mdinfo = mdinfo;
    }

    public String getArtnam() {
        return artnam;
    }

    public void setArtnam(String artnam) {
        this.artnam = artnam;
    }

    public String getResolu() {
        return resolu;
    }

    public void setResolu(String resolu) {
        this.resolu = resolu;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getIntrod() {
        return introd;
    }

    public void setIntrod(String introd) {
        this.introd = introd;
    }

    public String getFupath() {
        return fupath;
    }

    public void setFupath(String fupath) {
        this.fupath = fupath;
    }

    @Override
    public String toString() {
        return "Pcinf{" +
                "wbname='" + wbname + '\'' +
                ", wbsite='" + wbsite + '\'' +
                ", pgaddr='" + pgaddr + '\'' +
                ", pcaddr='" + pcaddr + '\'' +
                ", mdname='" + mdname + '\'' +
                ", mdinfo='" + mdinfo + '\'' +
                ", artnam='" + artnam + '\'' +
                ", resolu='" + resolu + '\'' +
                ", issues='" + issues + '\'' +
                ", labels='" + labels + '\'' +
                ", introd='" + introd + '\'' +
                ", fupath='" + fupath + '\'' +
                '}';
    }
}
