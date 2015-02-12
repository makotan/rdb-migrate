package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 14:16
 */
public class SchemaModel {
    public String schemaName;
    public String catalogName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchemaModel that = (SchemaModel) o;

        if (catalogName != null ? !catalogName.equals(that.catalogName) : that.catalogName != null) return false;
        if (schemaName != null ? !schemaName.equals(that.schemaName) : that.schemaName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schemaName != null ? schemaName.hashCode() : 0;
        result = 31 * result + (catalogName != null ? catalogName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SchemaModel{" +
                "schemaName='" + schemaName + '\'' +
                ", catalogName='" + catalogName + '\'' +
                '}';
    }
}
