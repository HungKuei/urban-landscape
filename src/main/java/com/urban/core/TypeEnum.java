package com.urban.core;

public enum TypeEnum {
    DESIGN(0,"设计"),
    BUILD(1,"施工"),
    PROTECT(2,"管护"),
    SUPERVISOR(3,"监理");

    private int code;
    private String typeName;

    TypeEnum(int code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public static String getTypeNameByCode(int code) {
        for (TypeEnum type : values()) {
            if (type.code == code) {
                return type.getTypeName();
            }
        }
        return null;
    }
}
