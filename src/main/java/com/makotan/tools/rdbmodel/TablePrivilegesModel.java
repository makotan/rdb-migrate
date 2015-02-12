package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 19:04
 */
public class TablePrivilegesModel {
    public String tableCatalog;
    public String tableSchema;
    public String tableName;
    public String grantor;
    public String grantee;
    public String privilege;
    public String isGrantable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TablePrivilegesModel that = (TablePrivilegesModel) o;

        if (grantee != null ? !grantee.equals(that.grantee) : that.grantee != null) return false;
        if (grantor != null ? !grantor.equals(that.grantor) : that.grantor != null) return false;
        if (isGrantable != null ? !isGrantable.equals(that.isGrantable) : that.isGrantable != null) return false;
        if (privilege != null ? !privilege.equals(that.privilege) : that.privilege != null) return false;
        if (tableCatalog != null ? !tableCatalog.equals(that.tableCatalog) : that.tableCatalog != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableCatalog != null ? tableCatalog.hashCode() : 0;
        result = 31 * result + (tableSchema != null ? tableSchema.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (grantor != null ? grantor.hashCode() : 0);
        result = 31 * result + (grantee != null ? grantee.hashCode() : 0);
        result = 31 * result + (privilege != null ? privilege.hashCode() : 0);
        result = 31 * result + (isGrantable != null ? isGrantable.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TablePrivilegesModel{" +
                "tableCatalog='" + tableCatalog + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", grantor='" + grantor + '\'' +
                ", grantee='" + grantee + '\'' +
                ", privilege='" + privilege + '\'' +
                ", isGrantable='" + isGrantable + '\'' +
                '}';
    }
}
