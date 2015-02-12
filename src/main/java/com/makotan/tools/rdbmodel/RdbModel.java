package com.makotan.tools.rdbmodel;

import java.sql.RowIdLifetime;
import java.util.List;
import java.util.Map;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 17:39
 */
public class RdbModel {

    public List<CatalogModel> catalogModels;
    public List<SchemaModel> schemaModels;
    public List<FunctionModel> functionModels;  // JDBC 3.0
    public List<FunctionColumnModel> functionColumnModels;  // JDBC 3.0

    public List<TableDescriptionModel> tableDescriptionModels;
    public List<TablePrivilegesModel> tablePrivilegesModels;
    public List<PrimaryKeyModel> primaryKeyModels;
    public List<ImportedKeyModel> importedKeyModels;
    public List<ExportedKeyModel> exportedKeyModels;
    public List<CrossReferenceModel> crossReferenceModels;

    public List<ColumnPrivilegesModel> columnPrivilegesModels;

    public List<String> userNames;
    public List<TypeInfoModel> typeInfoModels;

    public boolean allProceduresAreCallable;
    public boolean allTablesAreSelectable;
    public String URL;
    public String userName;
    public boolean isReadOnly;
    public boolean nullsAreSortedHigh;
    public boolean nullsAreSortedLow;
    public boolean nullsAreSortedAtStart;
    public boolean nullsAreSortedAtEnd;
    public String databaseProductName;
    public String databaseProductVersion;
    public String driverName;
    public String driverVersion;
    public int driverMajorVersion;
    public int driverMinorVersion;
    public boolean usesLocalFiles;
    public boolean usesLocalFilePerTable;
    public boolean supportsMixedCaseIdentifiers;
    public boolean storesUpperCaseIdentifiers;
    public boolean storesLowerCaseIdentifiers;
    public boolean storesMixedCaseIdentifiers;
    public boolean supportsMixedCaseQuotedIdentifiers;
    public boolean storesUpperCaseQuotedIdentifiers;
    public boolean storesLowerCaseQuotedIdentifiers;
    public boolean storesMixedCaseQuotedIdentifiers;
    public String identifierQuoteString;
    public String SQLKeywords;
    public String numericFunctions;
    public String stringFunctions;
    public String systemFunctions;
    public String timeDateFunctions;
    public String searchStringEscape;
    public String extraNameCharacters;
    public boolean supportsAlterTableWithAddColumn;
    public boolean supportsAlterTableWithDropColumn;
    public boolean supportsColumnAliasing;
    public boolean nullPlusNonNullIsNull;
    public boolean supportsConvert;
    public Map<Integer,Map<Integer,Boolean>> supportsConvertMap;
    public boolean supportsTableCorrelationNames;
    public boolean supportsDifferentTableCorrelationNames;
    public boolean supportsExpressionsInOrderBy;
    public boolean supportsOrderByUnrelated;
    public boolean supportsGroupBy;
    public boolean supportsGroupByUnrelated;
    public boolean supportsGroupByBeyondSelect;
    public boolean supportsLikeEscapeClause;
    public boolean supportsMultipleResultSets;
    public boolean supportsMultipleTransactions;
    public boolean supportsNonNullableColumns;
    public boolean supportsMinimumSQLGrammar;
    public boolean supportsCoreSQLGrammar;
    public boolean supportsExtendedSQLGrammar;
    public boolean supportsANSI92EntryLevelSQL;
    public boolean supportsANSI92IntermediateSQL;
    public boolean supportsANSI92FullSQL;
    public boolean supportsIntegrityEnhancementFacility;
    public boolean supportsOuterJoins;
    public boolean supportsFullOuterJoins;
    public boolean supportsLimitedOuterJoins;
    public String schemaTerm;
    public String procedureTerm;
    public String catalogTerm;
    public boolean isCatalogAtStart;
    public String catalogSeparator;
    public boolean supportsSchemasInDataManipulation;
    public boolean supportsSchemasInProcedureCalls;
    public boolean supportsSchemasInTableDefinitions;
    public boolean supportsSchemasInIndexDefinitions;
    public boolean supportsSchemasInPrivilegeDefinitions;
    public boolean supportsCatalogsInDataManipulation;
    public boolean supportsCatalogsInProcedureCalls;
    public boolean supportsCatalogsInTableDefinitions;
    public boolean supportsCatalogsInIndexDefinitions;
    public boolean supportsCatalogsInPrivilegeDefinitions;
    public boolean supportsPositionedDelete;
    public boolean supportsPositionedUpdate;
    public boolean supportsSelectForUpdate;
    public boolean supportsStoredProcedures;
    public boolean supportsSubqueriesInComparisons;
    public boolean supportsSubqueriesInExists;
    public boolean supportsSubqueriesInIns;
    public boolean supportsSubqueriesInQuantifieds;
    public boolean supportsCorrelatedSubqueries;
    public boolean supportsUnion;
    public boolean supportsUnionAll;
    public boolean supportsOpenCursorsAcrossCommit;
    public boolean supportsOpenCursorsAcrossRollback;
    public boolean supportsOpenStatementsAcrossCommit;
    public boolean supportsOpenStatementsAcrossRollback;

    public int maxBinaryLiteralLength;
    public int maxCharLiteralLength;
    public int maxColumnNameLength;
    public int maxColumnsInGroupBy;
    public int mxColumnsInIndex;
    public int maxColumnsInOrderBy;
    public int maxColumnsInSelect;
    public int maxColumnsInTable;
    public int maxConnections;
    public int maxCursorNameLength;
    public int maxIndexLength;
    public int maxSchemaNameLength;
    public int maxProcedureNameLength;
    public int maxCatalogNameLength;
    public int maxRowSize;
    public boolean doesMaxRowSizeIncludeBlobs;
    public int maxStatementLength;
    public int maxStatements;
    public int maxTableNameLength;
    public int maxTablesInSelect;
    public int maxUserNameLength;
    public int defaultTransactionIsolation;
    public boolean supportsTransactions;
    public boolean supportsDataDefinitionAndDataManipulationTransactions;
    public boolean supportsDataManipulationTransactionsOnly;
    public boolean dataDefinitionCausesTransactionCommit;
    public boolean dataDefinitionIgnoredInTransactions;


    //--------------------------JDBC 2.0-----------------------------

    public boolean supportsBatchUpdates;


    // ------------------- JDBC 3.0 -------------------------

    public boolean supportsSavepoints;
    public boolean supportsNamedParameters;
    public boolean supportsMultipleOpenResults;
    public boolean supportsGetGeneratedKeys;

    public int databaseMajorVersion;
    public int databaseMinorVersion;
    public int JDBCMajorVersion;
    public int JDBCMinorVersion;

    public int SQLStateType;
    public boolean locatorsUpdateCopy;
    public boolean supportsStatementPooling;


    //------------------------- JDBC 4.0 -----------------------------------

    public RowIdLifetime rowIdLifetime;
    public boolean supportsStoredFunctionsUsingCallSyntax;
    public boolean autoCommitFailureClosesAllResultSets;


    //--------------------------JDBC 4.1 -----------------------------

    public boolean  generatedKeyAlwaysReturned;

    //--------------------------JDBC 4.2 -----------------------------
    public long maxLogicalLobSize;
    public boolean supportsRefCursors;

    @Override
    public String toString() {
        return "RdbModel{" +
                "\ncatalogModels=" + catalogModels +
                "\n, schemaModels=" + schemaModels +
                "\n, functionModels=" + functionModels +
                "\n, functionColumnModels=" + functionColumnModels +
                "\n, tableDescriptionModels=" + tableDescriptionModels +
                "\n, tablePrivilegesModels=" + tablePrivilegesModels +
                "\n, primaryKeyModels=" + primaryKeyModels +
                "\n, importedKeyModels=" + importedKeyModels +
                "\n, exportedKeyModels=" + exportedKeyModels +
                "\n, crossReferenceModels=" + crossReferenceModels +
                "\n, columnPrivilegesModels=" + columnPrivilegesModels +
                "\n, userNames=" + userNames +
                "\n, typeInfoModels=" + typeInfoModels +
                "\n, allProceduresAreCallable=" + allProceduresAreCallable +
                ", allTablesAreSelectable=" + allTablesAreSelectable +
                ", URL='" + URL + '\'' +
                ", userName='" + userName + '\'' +
                ", isReadOnly=" + isReadOnly +
                ", nullsAreSortedHigh=" + nullsAreSortedHigh +
                ", nullsAreSortedLow=" + nullsAreSortedLow +
                ", nullsAreSortedAtStart=" + nullsAreSortedAtStart +
                ", nullsAreSortedAtEnd=" + nullsAreSortedAtEnd +
                ", databaseProductName='" + databaseProductName + '\'' +
                ", databaseProductVersion='" + databaseProductVersion + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverVersion='" + driverVersion + '\'' +
                ", driverMajorVersion=" + driverMajorVersion +
                ", driverMinorVersion=" + driverMinorVersion +
                ", usesLocalFiles=" + usesLocalFiles +
                ", usesLocalFilePerTable=" + usesLocalFilePerTable +
                ", supportsMixedCaseIdentifiers=" + supportsMixedCaseIdentifiers +
                ", storesUpperCaseIdentifiers=" + storesUpperCaseIdentifiers +
                ", storesLowerCaseIdentifiers=" + storesLowerCaseIdentifiers +
                ", storesMixedCaseIdentifiers=" + storesMixedCaseIdentifiers +
                ", supportsMixedCaseQuotedIdentifiers=" + supportsMixedCaseQuotedIdentifiers +
                ", storesUpperCaseQuotedIdentifiers=" + storesUpperCaseQuotedIdentifiers +
                ", storesLowerCaseQuotedIdentifiers=" + storesLowerCaseQuotedIdentifiers +
                ", storesMixedCaseQuotedIdentifiers=" + storesMixedCaseQuotedIdentifiers +
                ", identifierQuoteString='" + identifierQuoteString + '\'' +
                ", SQLKeywords='" + SQLKeywords + '\'' +
                ", numericFunctions='" + numericFunctions + '\'' +
                ", stringFunctions='" + stringFunctions + '\'' +
                ", systemFunctions='" + systemFunctions + '\'' +
                ", timeDateFunctions='" + timeDateFunctions + '\'' +
                ", searchStringEscape='" + searchStringEscape + '\'' +
                ", extraNameCharacters='" + extraNameCharacters + '\'' +
                ", supportsAlterTableWithAddColumn=" + supportsAlterTableWithAddColumn +
                ", supportsAlterTableWithDropColumn=" + supportsAlterTableWithDropColumn +
                ", supportsColumnAliasing=" + supportsColumnAliasing +
                ", nullPlusNonNullIsNull=" + nullPlusNonNullIsNull +
                ", supportsConvert=" + supportsConvert +
                ", supportsConvertMap=" + supportsConvertMap +
                ", supportsTableCorrelationNames=" + supportsTableCorrelationNames +
                ", supportsDifferentTableCorrelationNames=" + supportsDifferentTableCorrelationNames +
                ", supportsExpressionsInOrderBy=" + supportsExpressionsInOrderBy +
                ", supportsOrderByUnrelated=" + supportsOrderByUnrelated +
                ", supportsGroupBy=" + supportsGroupBy +
                ", supportsGroupByUnrelated=" + supportsGroupByUnrelated +
                ", supportsGroupByBeyondSelect=" + supportsGroupByBeyondSelect +
                ", supportsLikeEscapeClause=" + supportsLikeEscapeClause +
                ", supportsMultipleResultSets=" + supportsMultipleResultSets +
                ", supportsMultipleTransactions=" + supportsMultipleTransactions +
                ", supportsNonNullableColumns=" + supportsNonNullableColumns +
                ", supportsMinimumSQLGrammar=" + supportsMinimumSQLGrammar +
                ", supportsCoreSQLGrammar=" + supportsCoreSQLGrammar +
                ", supportsExtendedSQLGrammar=" + supportsExtendedSQLGrammar +
                ", supportsANSI92EntryLevelSQL=" + supportsANSI92EntryLevelSQL +
                ", supportsANSI92IntermediateSQL=" + supportsANSI92IntermediateSQL +
                ", supportsANSI92FullSQL=" + supportsANSI92FullSQL +
                ", supportsIntegrityEnhancementFacility=" + supportsIntegrityEnhancementFacility +
                ", supportsOuterJoins=" + supportsOuterJoins +
                ", supportsFullOuterJoins=" + supportsFullOuterJoins +
                ", supportsLimitedOuterJoins=" + supportsLimitedOuterJoins +
                ", schemaTerm='" + schemaTerm + '\'' +
                ", procedureTerm='" + procedureTerm + '\'' +
                ", catalogTerm='" + catalogTerm + '\'' +
                ", isCatalogAtStart=" + isCatalogAtStart +
                ", catalogSeparator='" + catalogSeparator + '\'' +
                ", supportsSchemasInDataManipulation=" + supportsSchemasInDataManipulation +
                ", supportsSchemasInProcedureCalls=" + supportsSchemasInProcedureCalls +
                ", supportsSchemasInTableDefinitions=" + supportsSchemasInTableDefinitions +
                ", supportsSchemasInIndexDefinitions=" + supportsSchemasInIndexDefinitions +
                ", supportsSchemasInPrivilegeDefinitions=" + supportsSchemasInPrivilegeDefinitions +
                ", supportsCatalogsInDataManipulation=" + supportsCatalogsInDataManipulation +
                ", supportsCatalogsInProcedureCalls=" + supportsCatalogsInProcedureCalls +
                ", supportsCatalogsInTableDefinitions=" + supportsCatalogsInTableDefinitions +
                ", supportsCatalogsInIndexDefinitions=" + supportsCatalogsInIndexDefinitions +
                ", supportsCatalogsInPrivilegeDefinitions=" + supportsCatalogsInPrivilegeDefinitions +
                ", supportsPositionedDelete=" + supportsPositionedDelete +
                ", supportsPositionedUpdate=" + supportsPositionedUpdate +
                ", supportsSelectForUpdate=" + supportsSelectForUpdate +
                ", supportsStoredProcedures=" + supportsStoredProcedures +
                ", supportsSubqueriesInComparisons=" + supportsSubqueriesInComparisons +
                ", supportsSubqueriesInExists=" + supportsSubqueriesInExists +
                ", supportsSubqueriesInIns=" + supportsSubqueriesInIns +
                ", supportsSubqueriesInQuantifieds=" + supportsSubqueriesInQuantifieds +
                ", supportsCorrelatedSubqueries=" + supportsCorrelatedSubqueries +
                ", supportsUnion=" + supportsUnion +
                ", supportsUnionAll=" + supportsUnionAll +
                ", supportsOpenCursorsAcrossCommit=" + supportsOpenCursorsAcrossCommit +
                ", supportsOpenCursorsAcrossRollback=" + supportsOpenCursorsAcrossRollback +
                ", supportsOpenStatementsAcrossCommit=" + supportsOpenStatementsAcrossCommit +
                ", supportsOpenStatementsAcrossRollback=" + supportsOpenStatementsAcrossRollback +
                ", maxBinaryLiteralLength=" + maxBinaryLiteralLength +
                ", maxCharLiteralLength=" + maxCharLiteralLength +
                ", maxColumnNameLength=" + maxColumnNameLength +
                ", maxColumnsInGroupBy=" + maxColumnsInGroupBy +
                ", mxColumnsInIndex=" + mxColumnsInIndex +
                ", maxColumnsInOrderBy=" + maxColumnsInOrderBy +
                ", maxColumnsInSelect=" + maxColumnsInSelect +
                ", maxColumnsInTable=" + maxColumnsInTable +
                ", maxConnections=" + maxConnections +
                ", maxCursorNameLength=" + maxCursorNameLength +
                ", maxIndexLength=" + maxIndexLength +
                ", maxSchemaNameLength=" + maxSchemaNameLength +
                ", maxProcedureNameLength=" + maxProcedureNameLength +
                ", maxCatalogNameLength=" + maxCatalogNameLength +
                ", maxRowSize=" + maxRowSize +
                ", doesMaxRowSizeIncludeBlobs=" + doesMaxRowSizeIncludeBlobs +
                ", maxStatementLength=" + maxStatementLength +
                ", maxStatements=" + maxStatements +
                ", maxTableNameLength=" + maxTableNameLength +
                ", maxTablesInSelect=" + maxTablesInSelect +
                ", maxUserNameLength=" + maxUserNameLength +
                ", defaultTransactionIsolation=" + defaultTransactionIsolation +
                ", supportsTransactions=" + supportsTransactions +
                ", supportsDataDefinitionAndDataManipulationTransactions=" + supportsDataDefinitionAndDataManipulationTransactions +
                ", supportsDataManipulationTransactionsOnly=" + supportsDataManipulationTransactionsOnly +
                ", dataDefinitionCausesTransactionCommit=" + dataDefinitionCausesTransactionCommit +
                ", dataDefinitionIgnoredInTransactions=" + dataDefinitionIgnoredInTransactions +
                ", supportsBatchUpdates=" + supportsBatchUpdates +
                ", supportsSavepoints=" + supportsSavepoints +
                ", supportsNamedParameters=" + supportsNamedParameters +
                ", supportsMultipleOpenResults=" + supportsMultipleOpenResults +
                ", supportsGetGeneratedKeys=" + supportsGetGeneratedKeys +
                ", databaseMajorVersion=" + databaseMajorVersion +
                ", databaseMinorVersion=" + databaseMinorVersion +
                ", JDBCMajorVersion=" + JDBCMajorVersion +
                ", JDBCMinorVersion=" + JDBCMinorVersion +
                ", SQLStateType=" + SQLStateType +
                ", locatorsUpdateCopy=" + locatorsUpdateCopy +
                ", supportsStatementPooling=" + supportsStatementPooling +
                ", rowIdLifetime=" + rowIdLifetime +
                ", supportsStoredFunctionsUsingCallSyntax=" + supportsStoredFunctionsUsingCallSyntax +
                ", autoCommitFailureClosesAllResultSets=" + autoCommitFailureClosesAllResultSets +
                ", generatedKeyAlwaysReturned=" + generatedKeyAlwaysReturned +
                ", maxLogicalLobSize=" + maxLogicalLobSize +
                ", supportsRefCursors=" + supportsRefCursors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RdbModel rdbModel = (RdbModel) o;

        if (catalogModels != null ? !catalogModels.equals(rdbModel.catalogModels) : rdbModel.catalogModels != null)
            return false;
        if (crossReferenceModels != null ? !crossReferenceModels.equals(rdbModel.crossReferenceModels) : rdbModel.crossReferenceModels != null)
            return false;
        if (exportedKeyModels != null ? !exportedKeyModels.equals(rdbModel.exportedKeyModels) : rdbModel.exportedKeyModels != null)
            return false;
        if (importedKeyModels != null ? !importedKeyModels.equals(rdbModel.importedKeyModels) : rdbModel.importedKeyModels != null)
            return false;
        if (primaryKeyModels != null ? !primaryKeyModels.equals(rdbModel.primaryKeyModels) : rdbModel.primaryKeyModels != null)
            return false;
        if (schemaModels != null ? !schemaModels.equals(rdbModel.schemaModels) : rdbModel.schemaModels != null)
            return false;
        if (tableDescriptionModels != null ? !tableDescriptionModels.equals(rdbModel.tableDescriptionModels) : rdbModel.tableDescriptionModels != null)
            return false;
        if (tablePrivilegesModels != null ? !tablePrivilegesModels.equals(rdbModel.tablePrivilegesModels) : rdbModel.tablePrivilegesModels != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catalogModels != null ? catalogModels.hashCode() : 0;
        result = 31 * result + (schemaModels != null ? schemaModels.hashCode() : 0);
        result = 31 * result + (tableDescriptionModels != null ? tableDescriptionModels.hashCode() : 0);
        result = 31 * result + (tablePrivilegesModels != null ? tablePrivilegesModels.hashCode() : 0);
        result = 31 * result + (primaryKeyModels != null ? primaryKeyModels.hashCode() : 0);
        result = 31 * result + (importedKeyModels != null ? importedKeyModels.hashCode() : 0);
        result = 31 * result + (exportedKeyModels != null ? exportedKeyModels.hashCode() : 0);
        result = 31 * result + (crossReferenceModels != null ? crossReferenceModels.hashCode() : 0);
        return result;
    }
}
