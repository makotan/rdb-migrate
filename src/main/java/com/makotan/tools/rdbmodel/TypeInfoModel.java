package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 19:29
 */
public class TypeInfoModel {
    public String typeName;
    public Integer dataType;
    public Integer precision;
    public String literalPrefix;
    public String literalSuffix;
    public String createParams;
    public Short nullable;
    public Boolean caseSensitive;
    public Short searchable;
    public Boolean unsignedAttribute;
    public Boolean fixedPrecScale;
    public Boolean autoIncrement;
    public String localTypeName;
    public Short minimumScale;
    public Short maximumScale;
    public Integer numPrecRadix;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeInfoModel that = (TypeInfoModel) o;

        if (autoIncrement != null ? !autoIncrement.equals(that.autoIncrement) : that.autoIncrement != null)
            return false;
        if (caseSensitive != null ? !caseSensitive.equals(that.caseSensitive) : that.caseSensitive != null)
            return false;
        if (createParams != null ? !createParams.equals(that.createParams) : that.createParams != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (fixedPrecScale != null ? !fixedPrecScale.equals(that.fixedPrecScale) : that.fixedPrecScale != null)
            return false;
        if (literalPrefix != null ? !literalPrefix.equals(that.literalPrefix) : that.literalPrefix != null)
            return false;
        if (literalSuffix != null ? !literalSuffix.equals(that.literalSuffix) : that.literalSuffix != null)
            return false;
        if (localTypeName != null ? !localTypeName.equals(that.localTypeName) : that.localTypeName != null)
            return false;
        if (maximumScale != null ? !maximumScale.equals(that.maximumScale) : that.maximumScale != null) return false;
        if (minimumScale != null ? !minimumScale.equals(that.minimumScale) : that.minimumScale != null) return false;
        if (nullable != null ? !nullable.equals(that.nullable) : that.nullable != null) return false;
        if (numPrecRadix != null ? !numPrecRadix.equals(that.numPrecRadix) : that.numPrecRadix != null) return false;
        if (precision != null ? !precision.equals(that.precision) : that.precision != null) return false;
        if (searchable != null ? !searchable.equals(that.searchable) : that.searchable != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (unsignedAttribute != null ? !unsignedAttribute.equals(that.unsignedAttribute) : that.unsignedAttribute != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeName != null ? typeName.hashCode() : 0;
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (precision != null ? precision.hashCode() : 0);
        result = 31 * result + (literalPrefix != null ? literalPrefix.hashCode() : 0);
        result = 31 * result + (literalSuffix != null ? literalSuffix.hashCode() : 0);
        result = 31 * result + (createParams != null ? createParams.hashCode() : 0);
        result = 31 * result + (nullable != null ? nullable.hashCode() : 0);
        result = 31 * result + (caseSensitive != null ? caseSensitive.hashCode() : 0);
        result = 31 * result + (searchable != null ? searchable.hashCode() : 0);
        result = 31 * result + (unsignedAttribute != null ? unsignedAttribute.hashCode() : 0);
        result = 31 * result + (fixedPrecScale != null ? fixedPrecScale.hashCode() : 0);
        result = 31 * result + (autoIncrement != null ? autoIncrement.hashCode() : 0);
        result = 31 * result + (localTypeName != null ? localTypeName.hashCode() : 0);
        result = 31 * result + (minimumScale != null ? minimumScale.hashCode() : 0);
        result = 31 * result + (maximumScale != null ? maximumScale.hashCode() : 0);
        result = 31 * result + (numPrecRadix != null ? numPrecRadix.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n\tTypeInfoModel{" +
                "typeName='" + typeName + '\'' +
                ", dataType=" + dataType +
                ", precision=" + precision +
                ", literalPrefix='" + literalPrefix + '\'' +
                ", literalSuffix='" + literalSuffix + '\'' +
                ", createParams='" + createParams + '\'' +
                ", nullable=" + nullable +
                ", caseSensitive=" + caseSensitive +
                ", searchable=" + searchable +
                ", unsignedAttribute=" + unsignedAttribute +
                ", fixedPrecScale=" + fixedPrecScale +
                ", autoIncrement=" + autoIncrement +
                ", localTypeName='" + localTypeName + '\'' +
                ", minimumScale=" + minimumScale +
                ", maximumScale=" + maximumScale +
                ", numPrecRadix=" + numPrecRadix +
                '}';
    }
}
