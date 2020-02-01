package com.treshermanas.thcweb.beans.users;


import com.treshermanas.thcweb.beans.Module;
import com.treshermanas.thcweb.beans.permissions.Perms;

public class RightDefinitionDto {

    private String label;
    private Perms perms;
    private String subperms;
    private String type;
    private Module module;


    public RightDefinitionDto() {

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Perms getPerms() {
        return perms;
    }

    public void setPerms(Perms perms) {
        this.perms = perms;
    }

    public String getSubperms() {
        return subperms;
    }

    public void setSubperms(String subperms) {
        this.subperms = subperms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
