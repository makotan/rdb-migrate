package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 18:56
 */
public class CatalogModel {
    public String catalogName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogModel that = (CatalogModel) o;

        if (catalogName != null ? !catalogName.equals(that.catalogName) : that.catalogName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return catalogName != null ? catalogName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CatalogModel{" +
                "catalogName='" + catalogName + '\'' +
                '}';
    }
}
