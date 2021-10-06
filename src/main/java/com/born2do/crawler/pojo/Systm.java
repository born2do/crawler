package com.born2do.crawler.pojo;

import java.io.Serializable;

/**
 * @author chenhy
 * @date 2021/8/31
 */
public class Systm implements Serializable {

    private String sysuid;
    private String syscod;
    private String sysnam;

    public Systm() {
    }

    public Systm(String sysuid, String syscod, String sysnam) {
        this.sysuid = sysuid;
        this.syscod = syscod;
        this.sysnam = sysnam;
    }

    public String getSysuid() {
        return sysuid;
    }

    public void setSysuid(String sysuid) {
        this.sysuid = sysuid;
    }

    public String getSyscod() {
        return syscod;
    }

    public void setSyscod(String syscod) {
        this.syscod = syscod;
    }

    public String getSysnam() {
        return sysnam;
    }

    public void setSysnam(String sysnam) {
        this.sysnam = sysnam;
    }

    @Override
    public String toString() {
        return "Systm{" +
                "sysuid='" + sysuid + '\'' +
                ", syscod='" + syscod + '\'' +
                ", sysnam='" + sysnam + '\'' +
                '}';
    }
}
