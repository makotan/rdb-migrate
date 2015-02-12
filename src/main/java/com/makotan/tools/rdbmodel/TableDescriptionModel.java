package com.makotan.tools.rdbmodel;

import java.util.List;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 18:52
 */
public class TableDescriptionModel {
    public String tableCatalog;
    public String tableSchema;
    public String tableName;
    public String tableType;
    public String comment;
    public String typesCatalog;
    public String typesSchema;
    public String typeName;
    public String selfReferencingColumnName;
    public String refGeneration;
    public List<IndexInfoModel> indexInfoModelsUniqueApproximate;
    public List<IndexInfoModel> indexInfoModelsUniqueNonApproximate;
    public List<IndexInfoModel> indexInfoModelsNonUniqueApproximate;
    public List<IndexInfoModel> indexInfoModelsNonUniqueNonApproximate;
    public List<TableColumnModel> tableColumnModels;


    public boolean equalsFields(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableDescriptionModel that = (TableDescriptionModel) o;

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (refGeneration != null ? !refGeneration.equals(that.refGeneration) : that.refGeneration != null)
            return false;
        if (selfReferencingColumnName != null ? !selfReferencingColumnName.equals(that.selfReferencingColumnName) : that.selfReferencingColumnName != null)
            return false;
        if (tableCatalog != null ? !tableCatalog.equals(that.tableCatalog) : that.tableCatalog != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableType != null ? !tableType.equals(that.tableType) : that.tableType != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (typesCatalog != null ? !typesCatalog.equals(that.typesCatalog) : that.typesCatalog != null) return false;
        if (typesSchema != null ? !typesSchema.equals(that.typesSchema) : that.typesSchema != null) return false;

        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableDescriptionModel that = (TableDescriptionModel) o;

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (indexInfoModelsNonUniqueApproximate != null ? !indexInfoModelsNonUniqueApproximate.equals(that.indexInfoModelsNonUniqueApproximate) : that.indexInfoModelsNonUniqueApproximate != null)
            return false;
        if (indexInfoModelsNonUniqueNonApproximate != null ? !indexInfoModelsNonUniqueNonApproximate.equals(that.indexInfoModelsNonUniqueNonApproximate) : that.indexInfoModelsNonUniqueNonApproximate != null)
            return false;
        if (indexInfoModelsUniqueApproximate != null ? !indexInfoModelsUniqueApproximate.equals(that.indexInfoModelsUniqueApproximate) : that.indexInfoModelsUniqueApproximate != null)
            return false;
        if (indexInfoModelsUniqueNonApproximate != null ? !indexInfoModelsUniqueNonApproximate.equals(that.indexInfoModelsUniqueNonApproximate) : that.indexInfoModelsUniqueNonApproximate != null)
            return false;
        if (refGeneration != null ? !refGeneration.equals(that.refGeneration) : that.refGeneration != null)
            return false;
        if (selfReferencingColumnName != null ? !selfReferencingColumnName.equals(that.selfReferencingColumnName) : that.selfReferencingColumnName != null)
            return false;
        if (tableCatalog != null ? !tableCatalog.equals(that.tableCatalog) : that.tableCatalog != null) return false;
        if (tableColumnModels != null ? !tableColumnModels.equals(that.tableColumnModels) : that.tableColumnModels != null)
            return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableType != null ? !tableType.equals(that.tableType) : that.tableType != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (typesCatalog != null ? !typesCatalog.equals(that.typesCatalog) : that.typesCatalog != null) return false;
        if (typesSchema != null ? !typesSchema.equals(that.typesSchema) : that.typesSchema != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableCatalog != null ? tableCatalog.hashCode() : 0;
        result = 31 * result + (tableSchema != null ? tableSchema.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (tableType != null ? tableType.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (typesCatalog != null ? typesCatalog.hashCode() : 0);
        result = 31 * result + (typesSchema != null ? typesSchema.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (selfReferencingColumnName != null ? selfReferencingColumnName.hashCode() : 0);
        result = 31 * result + (refGeneration != null ? refGeneration.hashCode() : 0);
        result = 31 * result + (indexInfoModelsUniqueApproximate != null ? indexInfoModelsUniqueApproximate.hashCode() : 0);
        result = 31 * result + (indexInfoModelsUniqueNonApproximate != null ? indexInfoModelsUniqueNonApproximate.hashCode() : 0);
        result = 31 * result + (indexInfoModelsNonUniqueApproximate != null ? indexInfoModelsNonUniqueApproximate.hashCode() : 0);
        result = 31 * result + (indexInfoModelsNonUniqueNonApproximate != null ? indexInfoModelsNonUniqueNonApproximate.hashCode() : 0);
        result = 31 * result + (tableColumnModels != null ? tableColumnModels.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n\tTableDescriptionModel{" +
                "tableCatalog='" + tableCatalog + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableType='" + tableType + '\'' +
                ", comment='" + comment + '\'' +
                ", typesCatalog='" + typesCatalog + '\'' +
                ", typesSchema='" + typesSchema + '\'' +
                ", typeName='" + typeName + '\'' +
                ", selfReferencingColumnName='" + selfReferencingColumnName + '\'' +
                ", refGeneration='" + refGeneration + '\'' +
                "\n\t\t, indexInfoModelsUniqueApproximate=" + indexInfoModelsUniqueApproximate +
                "\n\t\t, indexInfoModelsUniqueNonApproximate=" + indexInfoModelsUniqueNonApproximate +
                "\n\t\t, indexInfoModelsNonUniqueApproximate=" + indexInfoModelsNonUniqueApproximate +
                "\n\t\t, indexInfoModelsNonUniqueNonApproximate=" + indexInfoModelsNonUniqueNonApproximate +
                "\n\t\t, tableColumnModels=" + tableColumnModels +
                '}';
    }
}
