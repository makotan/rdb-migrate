package com.makotan.tools.loader;

import com.makotan.tools.exception.RmException;
import com.makotan.tools.rdbmodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 15:33
 */
public abstract class ModelStdRdbLoader implements ModelRdbLoader {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    Connection conn;


    @Override
    public RdbModel load(String jdbcUrl) {
        try {
            conn = getConnection(jdbcUrl);
            return load(conn);
        } catch (Throwable th) {
            logger.error("load model " + jdbcUrl , th);
            throw new RmException(th);
        }
    }

    public RdbModel load(Connection conn) throws SQLException {

        DatabaseMetaData metaData = conn.getMetaData();
        
        logger.debug(metaData.toString());

        RdbModel rm =  toRdbModel(metaData);

        return rm;
    }

    Connection getConnection(String jdbcUrl) throws SQLException {
        logger.debug("getConnection {}" , jdbcUrl);
        Connection conn = DriverManager.getConnection(jdbcUrl);
        conn.setReadOnly(true);
        logger.info("connected {}" , jdbcUrl);
        return conn;
    }



    <T> T getParam(SQLSupplier<T> f) {
        try {
            return f.get();
        } catch (Throwable th) {
            return null;
        }
    }

    @FunctionalInterface
    private static interface SQLSupplier<T> {
        T get() throws SQLException;
    }

    @FunctionalInterface
    private static interface SQLFunction<T,R> {
        R apply(T t) throws SQLException;
    }

    RdbModel toRdbModel(final DatabaseMetaData metaData) throws SQLException {
        RdbModel model = new RdbModel();
        model.catalogModels = getCatalogModel(metaData);
        model.schemaModels = getSchemaModel(metaData);
        model.functionModels = getFunctionModel(metaData);
        model.functionColumnModels = getFunctionColumnModel(metaData);

        model.tableDescriptionModels = getTableDescriptionModel(metaData);
        model.tablePrivilegesModels = getTablePrivilegesModel(metaData);
        model.primaryKeyModels = getPrimaryKeyModel(metaData);
        model.importedKeyModels = getImportedKeyModel(metaData);
        model.exportedKeyModels = getExportedKeyModel(metaData);
        model.crossReferenceModels = getCrossReferenceModel(metaData);
        model.typeInfoModels = getTypeInfoModel(metaData);

        model.allProceduresAreCallable = getParam(metaData::allProceduresAreCallable);
        model.allTablesAreSelectable = getParam(metaData::allTablesAreSelectable);
        model.URL = getParam(metaData::getURL);
        model.userName = getParam(metaData::getUserName);
        model.isReadOnly = getParam(metaData::isReadOnly);
        model.nullsAreSortedHigh = getParam(metaData::nullsAreSortedHigh);
        model.nullsAreSortedLow = getParam(metaData::nullsAreSortedLow);
        model.nullsAreSortedAtStart = getParam(metaData::nullsAreSortedAtStart);
        model.nullsAreSortedAtEnd = getParam(metaData::nullsAreSortedAtEnd);
        model.databaseProductName = getParam(metaData::getDatabaseProductName);
        model.databaseProductVersion = getParam(metaData::getDatabaseProductVersion);
        model.driverName = getParam(metaData::getDriverName);
        model.driverVersion = getParam(metaData::getDriverVersion);
        model.driverMajorVersion = getParam(metaData::getDriverMajorVersion);
        model.driverMinorVersion = getParam(metaData::getDriverMinorVersion);
        model.usesLocalFiles = getParam(metaData::usesLocalFiles);
        model.usesLocalFilePerTable = getParam(metaData::usesLocalFilePerTable);
        model.supportsMixedCaseIdentifiers = getParam(metaData::supportsMixedCaseIdentifiers);
        model.storesUpperCaseIdentifiers = getParam(metaData::storesUpperCaseIdentifiers);
        model.storesLowerCaseIdentifiers = getParam(metaData::storesLowerCaseIdentifiers);
        model.storesMixedCaseIdentifiers = getParam(metaData::storesMixedCaseIdentifiers);
        model.supportsMixedCaseQuotedIdentifiers = getParam(metaData::supportsMixedCaseQuotedIdentifiers);
        model.storesUpperCaseQuotedIdentifiers = getParam(metaData::storesUpperCaseQuotedIdentifiers);
        model.storesLowerCaseQuotedIdentifiers = getParam(metaData::storesLowerCaseQuotedIdentifiers);
        model.storesMixedCaseQuotedIdentifiers = getParam(metaData::storesMixedCaseQuotedIdentifiers);
        model.identifierQuoteString = getParam(metaData::getIdentifierQuoteString);
        model.SQLKeywords = getParam(metaData::getSQLKeywords);
        model.numericFunctions = getParam(metaData::getNumericFunctions);
        model.stringFunctions = getParam(metaData::getStringFunctions);
        model.systemFunctions = getParam(metaData::getSystemFunctions);
        model.timeDateFunctions = getParam(metaData::getTimeDateFunctions);
        model.searchStringEscape = getParam(metaData::getSearchStringEscape);
        model.extraNameCharacters = getParam(metaData::getExtraNameCharacters);
        model.supportsAlterTableWithAddColumn = getParam(metaData::supportsAlterTableWithAddColumn);
        model.supportsAlterTableWithDropColumn = getParam(metaData::supportsAlterTableWithDropColumn);
        model.supportsColumnAliasing = getParam(metaData::supportsColumnAliasing);
        model.nullPlusNonNullIsNull = getParam(metaData::nullPlusNonNullIsNull);
        model.supportsConvert = getParam(metaData::supportsConvert);
        model.supportsConvertMap = getSupportsConvertMap(metaData);
        model.supportsTableCorrelationNames = getParam(metaData::supportsTableCorrelationNames);
        model.supportsDifferentTableCorrelationNames = getParam(metaData::supportsDifferentTableCorrelationNames);
        model.supportsExpressionsInOrderBy = getParam(metaData::supportsExpressionsInOrderBy);
        model.supportsOrderByUnrelated = getParam(metaData::supportsOrderByUnrelated);
        model.supportsGroupBy = getParam(metaData::supportsGroupBy);
        model.supportsGroupByUnrelated = getParam(metaData::supportsGroupByUnrelated);
        model.supportsGroupByBeyondSelect = getParam(metaData::supportsGroupByBeyondSelect);
        model.supportsLikeEscapeClause = getParam(metaData::supportsLikeEscapeClause);
        model.supportsMultipleResultSets = getParam(metaData::supportsMultipleResultSets);
        model.supportsMultipleTransactions = getParam(metaData::supportsMultipleTransactions);
        model.supportsNonNullableColumns = getParam(metaData::supportsNonNullableColumns);
        model.supportsMinimumSQLGrammar = getParam(metaData::supportsMinimumSQLGrammar);
        model.supportsCoreSQLGrammar = getParam(metaData::supportsCoreSQLGrammar);
        model.supportsExtendedSQLGrammar = getParam(metaData::supportsExtendedSQLGrammar);
        model.supportsANSI92EntryLevelSQL = getParam(metaData::supportsANSI92EntryLevelSQL);
        model.supportsANSI92IntermediateSQL = getParam(metaData::supportsANSI92IntermediateSQL);
        model.supportsANSI92FullSQL = getParam(metaData::supportsANSI92FullSQL);
        model.supportsIntegrityEnhancementFacility = getParam(metaData::supportsIntegrityEnhancementFacility);
        model.supportsOuterJoins = getParam(metaData::supportsOuterJoins);
        model.supportsFullOuterJoins = getParam(metaData::supportsFullOuterJoins);
        model.supportsLimitedOuterJoins = getParam(metaData::supportsLimitedOuterJoins);
        model.schemaTerm = getParam(metaData::getSchemaTerm);
        model.procedureTerm = getParam(metaData::getProcedureTerm);
        model.catalogTerm = getParam(metaData::getCatalogTerm);
        model.isCatalogAtStart = getParam(metaData::isCatalogAtStart);
        model.catalogSeparator = getParam(metaData::getCatalogSeparator);
        model.supportsSchemasInDataManipulation = getParam(metaData::supportsSchemasInDataManipulation);
        model.supportsSchemasInProcedureCalls = getParam(metaData::supportsSchemasInProcedureCalls);
        model.supportsSchemasInTableDefinitions = getParam(metaData::supportsSchemasInTableDefinitions);
        model.supportsSchemasInIndexDefinitions = getParam(metaData::supportsSchemasInIndexDefinitions);
        model.supportsSchemasInPrivilegeDefinitions = getParam(metaData::supportsSchemasInPrivilegeDefinitions);
        model.supportsCatalogsInDataManipulation = getParam(metaData::supportsCatalogsInDataManipulation);
        model.supportsCatalogsInProcedureCalls = getParam(metaData::supportsCatalogsInProcedureCalls);
        model.supportsCatalogsInTableDefinitions = getParam(metaData::supportsCatalogsInTableDefinitions);
        model.supportsCatalogsInIndexDefinitions = getParam(metaData::supportsCatalogsInIndexDefinitions);
        model.supportsCatalogsInPrivilegeDefinitions = getParam(metaData::supportsCatalogsInPrivilegeDefinitions);
        model.supportsPositionedDelete = getParam(metaData::supportsPositionedDelete);
        model.supportsPositionedUpdate = getParam(metaData::supportsPositionedUpdate);
        model.supportsSelectForUpdate = getParam(metaData::supportsSelectForUpdate);
        model.supportsStoredProcedures = getParam(metaData::supportsStoredProcedures);
        model.supportsSubqueriesInComparisons = getParam(metaData::supportsSubqueriesInComparisons);
        model.supportsSubqueriesInExists = getParam(metaData::supportsSubqueriesInExists);
        model.supportsSubqueriesInIns = getParam(metaData::supportsSubqueriesInIns);
        model.supportsSubqueriesInQuantifieds = getParam(metaData::supportsSubqueriesInQuantifieds);
        model.supportsCorrelatedSubqueries = getParam(metaData::supportsCorrelatedSubqueries);
        model.supportsUnion = getParam(metaData::supportsUnion);
        model.supportsUnionAll = getParam(metaData::supportsUnionAll);
        model.supportsOpenCursorsAcrossCommit = getParam(metaData::supportsOpenCursorsAcrossCommit);
        model.supportsOpenCursorsAcrossRollback = getParam(metaData::supportsOpenCursorsAcrossRollback);
        model.supportsOpenStatementsAcrossCommit = getParam(metaData::supportsOpenStatementsAcrossCommit);
        model.supportsOpenStatementsAcrossRollback = getParam(metaData::supportsOpenStatementsAcrossRollback);

        model.maxBinaryLiteralLength = getParam(metaData::getMaxBinaryLiteralLength);
        model.maxCharLiteralLength = getParam(metaData::getMaxCharLiteralLength);
        model.maxColumnNameLength = getParam(metaData::getMaxColumnNameLength);
        model.maxColumnsInGroupBy = getParam(metaData::getMaxColumnsInGroupBy);
        model.mxColumnsInIndex = getParam(metaData::getMaxColumnsInIndex);
        model.maxColumnsInOrderBy = getParam(metaData::getMaxColumnsInOrderBy);
        model.maxColumnsInSelect = getParam(metaData::getMaxColumnsInSelect);
        model.maxColumnsInTable = getParam(metaData::getMaxColumnsInTable);
        model.maxConnections = getParam(metaData::getMaxConnections);
        model.maxCursorNameLength = getParam(metaData::getMaxCursorNameLength);
        model.maxIndexLength = getParam(metaData::getMaxIndexLength);
        model.maxSchemaNameLength = getParam(metaData::getMaxSchemaNameLength);
        model.maxProcedureNameLength = getParam(metaData::getMaxProcedureNameLength);
        model.maxCatalogNameLength = getParam(metaData::getMaxCatalogNameLength);
        model.maxRowSize = getParam(metaData::getMaxRowSize);
        model.doesMaxRowSizeIncludeBlobs = getParam(metaData::doesMaxRowSizeIncludeBlobs);
        model.maxStatementLength = getParam(metaData::getMaxStatementLength);
        model.maxStatements = getParam(metaData::getMaxStatements);
        model.maxTableNameLength = getParam(metaData::getMaxTableNameLength);
        model.maxTablesInSelect = getParam(metaData::getMaxTablesInSelect);
        model.maxUserNameLength = getParam(metaData::getMaxUserNameLength);
        model.defaultTransactionIsolation = getParam(metaData::getDefaultTransactionIsolation);
        model.supportsTransactions = getParam(metaData::supportsTransactions);
        model.supportsDataDefinitionAndDataManipulationTransactions = getParam(metaData::supportsDataDefinitionAndDataManipulationTransactions);
        model.supportsDataManipulationTransactionsOnly = getParam(metaData::supportsDataManipulationTransactionsOnly);
        model.dataDefinitionCausesTransactionCommit = getParam(metaData::dataDefinitionCausesTransactionCommit);
        model.dataDefinitionIgnoredInTransactions = getParam(metaData::dataDefinitionIgnoredInTransactions);


        //--------------------------JDBC 2.0-----------------------------

        model.supportsBatchUpdates = getParam(metaData::supportsBatchUpdates);


        // ------------------- JDBC 3.0 -------------------------

        model.supportsSavepoints = getParam(metaData::supportsSavepoints);
        model.supportsNamedParameters = getParam(metaData::supportsNamedParameters);
        model.supportsMultipleOpenResults = getParam(metaData::supportsMultipleOpenResults);
        model.supportsGetGeneratedKeys = getParam(metaData::supportsGetGeneratedKeys);

        model.databaseMajorVersion = getParam(metaData::getDatabaseMajorVersion);
        model.databaseMinorVersion = getParam(metaData::getDatabaseMinorVersion);
        model.JDBCMajorVersion = getParam(metaData::getJDBCMajorVersion);
        model.JDBCMinorVersion = getParam(metaData::getJDBCMinorVersion);

        model.SQLStateType = getParam(metaData::getSQLStateType);
        model.locatorsUpdateCopy = getParam(metaData::locatorsUpdateCopy);
        model.supportsStatementPooling = getParam(metaData::supportsStatementPooling);


        //------------------------- JDBC 4.0 -----------------------------------

        model.rowIdLifetime = getParam(metaData::getRowIdLifetime);
        model.supportsStoredFunctionsUsingCallSyntax = getParam(metaData::supportsStoredFunctionsUsingCallSyntax);
        model.autoCommitFailureClosesAllResultSets = getParam(metaData::autoCommitFailureClosesAllResultSets);


        //--------------------------JDBC 4.1 -----------------------------

        model. generatedKeyAlwaysReturned = getParam(metaData::generatedKeyAlwaysReturned);

        //--------------------------JDBC 4.2 -----------------------------
        model.maxLogicalLobSize = getParam(metaData::getMaxLogicalLobSize);
        model.supportsRefCursors = getParam(metaData::supportsRefCursors);


        return model;
    }

    final int types[] = new int[]{
            Types.BIT,
            Types.TINYINT,
            Types.SMALLINT,
            Types.INTEGER,
            Types.BIGINT,
            Types.FLOAT,
            Types.REAL,
            Types.DOUBLE,
            Types.NUMERIC,
            Types.DECIMAL,
            Types.CHAR,
            Types.VARCHAR,
            Types.LONGVARCHAR,
            Types.DATE,
            Types.TIME,
            Types.TIMESTAMP,
            Types.BINARY,
            Types.VARBINARY,
            Types.LONGVARBINARY,
            Types.NULL,
            Types.OTHER,
            Types.JAVA_OBJECT,
            Types.DISTINCT,
            Types.STRUCT,
            Types.ARRAY,
            Types.BLOB,
            Types.CLOB,
            Types.REF,
            Types.DATALINK,
            Types.BOOLEAN,
            Types.ROWID,
            Types.NCHAR,
            Types.NVARCHAR,
            Types.LONGNVARCHAR,
            Types.NCLOB,
            Types.SQLXML,
            Types.REF_CURSOR,
            Types.TIME_WITH_TIMEZONE,
            Types.TIMESTAMP_WITH_TIMEZONE
    };
    Map<Integer, Map<Integer, Boolean>> getSupportsConvertMap(DatabaseMetaData metaData) {
        Map<Integer, Map<Integer, Boolean>> ret = new HashMap<>();

        for (int from : types) {
            Map<Integer, Boolean> fromMap = new HashMap<>();
            for (int to : types) {
                try {
                    boolean conv = metaData.supportsConvert(from, to);
                    fromMap.put(to, conv);
                } catch (SQLException e) {

                }
            }
            ret.put(from , fromMap);
        }
        return ret;
    }

    <T> List<T> getFromRs(ResultSet rs, SQLSupplier<T> c) {
        final List<T> models = new ArrayList<>();
        if (rs == null) {
            return models;
        }
        try {
            while (rs.next()) {
                T t = c.get();
                models.add(t);
            }
            return models;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    <T> T getRs(final ResultSet rs , SQLSupplier<T> f) {
        try {
            T v = f.get();
            if (rs.wasNull()) {
                return null;
            }
            return v;
        } catch (SQLException e) {
            return null;
        }
    }

    List<CatalogModel> getCatalogModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(metaData::getCatalogs);
        return getFromRs(rs, () -> {
            CatalogModel model = new CatalogModel();
            model.catalogName = getRs(rs , () -> rs.getString("TABLE_CAT"));
            return model;
        });
    }

    List<SchemaModel> getSchemaModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(metaData::getSchemas);
        return getFromRs(rs, () -> {
            SchemaModel model = new SchemaModel();
            model.schemaName = getRs(rs , () -> rs.getString("TABLE_SCHEM"));
            model.catalogName = getRs(rs , () -> rs.getString("TABLE_CATALOG"));
            return model;
        });
    }

    List<FunctionModel> getFunctionModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(() -> metaData.getFunctions(null , null , "%"));
        return getFromRs(rs, () -> {
            FunctionModel model = new FunctionModel();
            model.functionCatalog = getRs(rs , () -> rs.getString("FUNCTION_CAT"));
            model.functionSchema = getRs(rs , () -> rs.getString("FUNCTION_SCHEM"));
            model.functionName = getRs(rs , () -> rs.getString("FUNCTION_NAME"));
            model.functionComment = getRs(rs , () -> rs.getString("REMARKS"));
            model.functionType = getRs(rs , () -> rs.getShort("FUNCTION_TYPE"));
            model.specificName = getRs(rs , () -> rs.getString("SPECIFIC_NAME"));
            return model;
        });
    }

    List<FunctionColumnModel> getFunctionColumnModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(() -> metaData.getFunctionColumns(null, null, "%", "%"));
        return getFromRs(rs, () -> {
            FunctionColumnModel model = new FunctionColumnModel();
            model.functionCatalog = getRs(rs , () -> rs.getString("FUNCTION_CAT"));
            model.functionSchema = getRs(rs , () -> rs.getString("FUNCTION_SCHEM"));
            model.functionName = getRs(rs , () -> rs.getString("FUNCTION_NAME"));
            model.columnName = getRs(rs , () -> rs.getString("FUNCTION_NAME"));
            model.columnType = getRs(rs , () -> rs.getShort("COLUMN_NAME"));
            model.dataType = getRs(rs, () -> rs.getInt("COLUMN_TYPE"));
            model.typeName = getRs(rs , () -> rs.getString("TYPE_NAME"));
            model.precision = getRs(rs, () -> rs.getInt("PRECISION"));
            model.length = getRs(rs, () -> rs.getInt("LENGTH"));
            model.scale = getRs(rs, () -> rs.getShort("SCALE"));
            model.radix = getRs(rs, () -> rs.getShort("RADIX"));
            model.nullable = getRs(rs, () -> rs.getShort("NULLABLE"));
            model.comment = getRs(rs , () -> rs.getString("REMARKS"));
            model.charOctetLength = getRs(rs, () -> rs.getInt("CHAR_OCTET_LENGTH"));
            model.ordinalPosition = getRs(rs, () -> rs.getInt("ORDINAL_POSITION"));
            model.isNullable = getRs(rs , () -> rs.getString("IS_NULLABLE"));
            model.specificName = getRs(rs , () -> rs.getString("SPECIFIC_NAME"));
            return model;
        });
    }


    List<TableDescriptionModel> getTableDescriptionModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(() -> metaData.getTables(null, null, "%", new String[]{"TABLE", "VIEW"}));
        return getFromRs(rs, () -> {
            TableDescriptionModel model = new TableDescriptionModel();
            model.tableCatalog = getRs(rs , () -> rs.getString("TABLE_CAT"));
            model.tableSchema = getRs(rs , () -> rs.getString("TABLE_SCHEM"));
            model.tableName = getRs(rs , () -> rs.getString("TABLE_NAME"));
            model.tableType = getRs(rs , () -> rs.getString("TABLE_TYPE"));
            model.comment = getRs(rs , () -> rs.getString("REMARKS"));
            model.typesCatalog = getRs(rs , () -> rs.getString("TYPE_CAT"));
            model.typesSchema = getRs(rs , () -> rs.getString("TYPE_SCHEM"));
            model.typeName = getRs(rs , () -> rs.getString("TYPE_NAME"));
            model.selfReferencingColumnName = getRs(rs , () -> rs.getString("SELF_REFERENCING_COL_NAME"));
            model.refGeneration = getRs(rs , () -> rs.getString("REF_GENERATION"));
            model.indexInfoModelsUniqueApproximate = getIndexInfoModel(metaData, model.tableCatalog , model.tableSchema, model.tableName, true, true);
            model.indexInfoModelsUniqueNonApproximate = getIndexInfoModel(metaData , model.tableCatalog , model.tableSchema, model.tableName, true , false);
            model.indexInfoModelsNonUniqueApproximate = getIndexInfoModel(metaData, model.tableCatalog , model.tableSchema, model.tableName, false, true);
            model.indexInfoModelsNonUniqueNonApproximate = getIndexInfoModel(metaData, model.tableCatalog , model.tableSchema, model.tableName, false, false);
            model.tableColumnModels = getTableColumnModel(metaData, model.tableCatalog , model.tableSchema, model.tableName);
            return model;
        });
    }

    List<IndexInfoModel> getIndexInfoModel(final DatabaseMetaData metaData , String tableCatalog , String tableSchema , String tableName, boolean unique, boolean approximate) {
        final ResultSet rs = getParam(() -> metaData.getIndexInfo(tableCatalog, tableSchema, tableName, unique, approximate));
        return getFromRs(rs, () -> {
            IndexInfoModel model = new IndexInfoModel();
            model.tableCatalog = getRs(rs , () -> rs.getString("TABLE_CAT"));
            model.tableSchema = getRs(rs , () -> rs.getString("TABLE_SCHEM"));
            model.tableName = getRs(rs , () -> rs.getString("TABLE_NAME"));
            model.nonUnique = getRs(rs , () -> rs.getBoolean("NON_UNIQUE"));
            model.indexQualifier = getRs(rs , () -> rs.getString("INDEX_QUALIFIER"));
            model.indexName = getRs(rs , () -> rs.getString("INDEX_NAME"));
            model.type = getRs(rs , () -> rs.getShort("TYPE"));
            model.ordinalPosition = getRs(rs , () -> rs.getShort("ORDINAL_POSITION"));
            model.columnName = getRs(rs, () -> rs.getString("COLUMN_NAME"));
            model.ascOrDesc = getRs(rs, () -> rs.getString("ASC_OR_DESC"));
            model.cardinality = getRs(rs, () -> rs.getLong("CARDINALITY"));
            model.pages = getRs(rs, () -> rs.getLong("PAGES"));
            model.fileterCondition = getRs(rs, () -> rs.getString("FILTER_CONDITION"));
            return model;
        });
    }

    List<TableColumnModel> getTableColumnModel(final DatabaseMetaData metaData , String tableCatalog , String tableSchema , String tableName) {
        final ResultSet rs = getParam(() -> metaData.getColumns(tableCatalog, tableSchema, tableName, "%"));
        return getFromRs(rs, () -> {
            TableColumnModel model = new TableColumnModel();
            model.tableCatalog = getRs(rs , () -> rs.getString("TABLE_CAT"));
            model.tableSchema = getRs(rs , () -> rs.getString("TABLE_SCHEM"));
            model.tableName = getRs(rs , () -> rs.getString("TABLE_NAME"));
            model.columnName = getRs(rs , () -> rs.getString("COLUMN_NAME"));
            model.sqlType = getRs(rs , () -> rs.getInt("DATA_TYPE"));
            model.typeName = getRs(rs , () -> rs.getString("TYPE_NAME"));
            model.columnSize = getRs(rs , () -> rs.getInt("COLUMN_SIZE"));
            model.decimalDigits = getRs(rs , () -> rs.getInt("DECIMAL_DIGITS"));
            model.numPrecRadix = getRs(rs , () -> rs.getInt("NUM_PREC_RADIX"));
            model.nullable = getRs(rs , () -> rs.getInt("NULLABLE"));
            model.comment = getRs(rs , () -> rs.getString("REMARKS"));
            model.columnDefault = getRs(rs , () -> rs.getString("COLUMN_DEF"));
            model.charOctetLength = getRs(rs , () -> rs.getInt("CHAR_OCTET_LENGTH"));
            model.ordinalPosition = getRs(rs , () -> rs.getInt("ORDINAL_POSITION"));
            model.isNullable = getRs(rs , () -> rs.getString("IS_NULLABLE"));
            model.scopeCatalog = getRs(rs , () -> rs.getString("SCOPE_CATALOG"));
            model.scopeSchema = getRs(rs , () -> rs.getString("SCOPE_SCHEMA"));
            model.scopeTable = getRs(rs , () -> rs.getString("SCOPE_TABLE"));
            model.sourceDataType = getRs(rs , () -> rs.getShort("SOURCE_DATA_TYPE"));
            model.isAutoincrement = getRs(rs , () -> rs.getString("IS_AUTOINCREMENT"));
            model.isGeneratedColumn = getRs(rs , () -> rs.getString("IS_GENERATEDCOLUMN"));
            return model;
        });
    }

    List<TablePrivilegesModel> getTablePrivilegesModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(() -> metaData.getTablePrivileges(null, null, "%"));
        return getFromRs(rs, () -> {
            TablePrivilegesModel model = new TablePrivilegesModel();
            model.tableCatalog = getRs(rs , () -> rs.getString("TABLE_CAT"));
            model.tableSchema = getRs(rs, () -> rs.getString("TABLE_SCHEM"));
            model.tableName = getRs(rs , () -> rs.getString("TABLE_NAME"));
            model.grantor = getRs(rs , () -> rs.getString("GRANTOR"));
            model.grantee = getRs(rs , () -> rs.getString("GRANTEE"));
            model.privilege = getRs(rs , () -> rs.getString("PRIVILEGE"));
            model.isGrantable = getRs(rs , () -> rs.getString("IS_GRANTABLE"));
            return model;
        });
    }

    List<PrimaryKeyModel> getPrimaryKeyModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(() -> metaData.getPrimaryKeys(null, null, null));
        return getFromRs(rs, () -> {
            PrimaryKeyModel model = new PrimaryKeyModel();
            model.tableCatalog = getRs(rs , () -> rs.getString("TABLE_CAT"));
            model.tableSchema = getRs(rs , () -> rs.getString("TABLE_SCHEM"));
            model.tableName = getRs(rs , () -> rs.getString("TABLE_NAME"));
            model.columnName = getRs(rs , () -> rs.getString("COLUMN_NAME"));
            model.keySeq = getRs(rs , () -> rs.getShort("KEY_SEQ"));
            model.pkName = getRs(rs , () -> rs.getString("PK_NAME"));
            return model;
        });
    }

    List<ImportedKeyModel> getImportedKeyModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(() -> metaData.getImportedKeys(null, null, null));
        return getFromRs(rs, () -> {
            ImportedKeyModel model = new ImportedKeyModel();
            model.pkTableCatalog = getRs(rs , () -> rs.getString("PKTABLE_CAT"));
            model.pkTableSchema = getRs(rs , () -> rs.getString("PKTABLE_SCHEM"));
            model.pkTableName = getRs(rs , () -> rs.getString("PKTABLE_NAME"));
            model.pkColumnName = getRs(rs , () -> rs.getString("PKCOLUMN_NAME"));

            model.fkTableCatalog = getRs(rs , () -> rs.getString("FKTABLE_CAT"));
            model.fkTableSchema = getRs(rs , () -> rs.getString("FKTABLE_SCHEM"));
            model.fkTableName = getRs(rs , () -> rs.getString("FKTABLE_NAME"));
            model.fkColumnName = getRs(rs , () -> rs.getString("FKCOLUMN_NAME"));

            model.keySeq = getRs(rs, () -> rs.getShort("KEY_SEQ"));

            model.updateRule = getRs(rs, () -> rs.getShort("UPDATE_RULE"));
            model.deleteRule = getRs(rs, () -> rs.getShort("DELETE_RULE"));

            model.fkName = getRs(rs , () -> rs.getString("FK_NAME"));
            model.pkName = getRs(rs , () -> rs.getString("PK_NAME"));
            model.deferrability = getRs(rs, () -> rs.getShort("DEFERRABILITY"));
            return model;
        });
    }

    List<ExportedKeyModel> getExportedKeyModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(() -> metaData.getExportedKeys(null, null, null));
        return getFromRs(rs, () -> {
            ExportedKeyModel model = new ExportedKeyModel();
            model.pkTableCatalog = getRs(rs , () -> rs.getString("PKTABLE_CAT"));
            model.pkTableSchema = getRs(rs , () -> rs.getString("PKTABLE_SCHEM"));
            model.pkTableName = getRs(rs , () -> rs.getString("PKTABLE_NAME"));
            model.pkColumnName = getRs(rs , () -> rs.getString("PKCOLUMN_NAME"));

            model.fkTableCatalog = getRs(rs , () -> rs.getString("FKTABLE_CAT"));
            model.fkTableSchema = getRs(rs , () -> rs.getString("FKTABLE_SCHEM"));
            model.fkTableName = getRs(rs , () -> rs.getString("FKTABLE_NAME"));
            model.fkColumnName = getRs(rs , () -> rs.getString("FKCOLUMN_NAME"));

            model.keySeq = getRs(rs, () -> rs.getShort("KEY_SEQ"));

            model.updateRule = getRs(rs, () -> rs.getShort("UPDATE_RULE"));
            model.deleteRule = getRs(rs, () -> rs.getShort("DELETE_RULE"));

            model.fkName = getRs(rs , () -> rs.getString("FK_NAME"));
            model.pkName = getRs(rs , () -> rs.getString("PK_NAME"));
            model.deferrability = getRs(rs, () -> rs.getShort("DEFERRABILITY"));
            return model;
        });
    }

    List<CrossReferenceModel> getCrossReferenceModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(() -> metaData.getCrossReference(null, null, null, null, null, null));
        return getFromRs(rs, () -> {
            CrossReferenceModel model = new CrossReferenceModel();
            model.pkTableCatalog = getRs(rs , () -> rs.getString("PKTABLE_CAT"));
            model.pkTableSchema = getRs(rs , () -> rs.getString("PKTABLE_SCHEM"));
            model.pkTableName = getRs(rs , () -> rs.getString("PKTABLE_NAME"));
            model.pkColumnName = getRs(rs , () -> rs.getString("PKCOLUMN_NAME"));

            model.fkTableCatalog = getRs(rs , () -> rs.getString("FKTABLE_CAT"));
            model.fkTableSchema = getRs(rs , () -> rs.getString("FKTABLE_SCHEM"));
            model.fkTableName = getRs(rs , () -> rs.getString("FKTABLE_NAME"));
            model.fkColumnName = getRs(rs , () -> rs.getString("FKCOLUMN_NAME"));

            model.keySeq = getRs(rs, () -> rs.getShort("KEY_SEQ"));

            model.updateRule = getRs(rs, () -> rs.getShort("UPDATE_RULE"));
            model.deleteRule = getRs(rs, () -> rs.getShort("DELETE_RULE"));

            model.fkName = getRs(rs , () -> rs.getString("FK_NAME"));
            model.pkName = getRs(rs , () -> rs.getString("PK_NAME"));
            model.deferrability = getRs(rs, () -> rs.getShort("DEFERRABILITY"));
            return model;
        });
    }

    List<TypeInfoModel> getTypeInfoModel(final DatabaseMetaData metaData) {
        final ResultSet rs = getParam(metaData::getTypeInfo);
        return getFromRs(rs, () -> {
            TypeInfoModel model = new TypeInfoModel();
            model.typeName = getRs(rs , () -> rs.getString("TYPE_NAME"));
            model.dataType = getRs(rs , () -> rs.getInt("DATA_TYPE"));
            model.precision = getRs(rs , () -> rs.getInt("PRECISION"));
            model.literalPrefix = getRs(rs , () -> rs.getString("LITERAL_PREFIX"));
            model.literalSuffix = getRs(rs , () -> rs.getString("LITERAL_SUFFIX"));
            model.createParams = getRs(rs , () -> rs.getString("CREATE_PARAMS"));
            model.nullable = getRs(rs , () -> rs.getShort("NULLABLE"));
            model.caseSensitive = getRs(rs , () -> rs.getBoolean("CASE_SENSITIVE"));
            model.searchable = getRs(rs , () -> rs.getShort("SEARCHABLE"));
            model.unsignedAttribute = getRs(rs , () -> rs.getBoolean("UNSIGNED_ATTRIBUTE"));
            model.fixedPrecScale = getRs(rs , () -> rs.getBoolean("FIXED_PREC_SCALE"));
            model.autoIncrement = getRs(rs , () -> rs.getBoolean("AUTO_INCREMENT"));
            model.localTypeName = getRs(rs , () -> rs.getString("LOCAL_TYPE_NAME"));
            model.minimumScale = getRs(rs , () -> rs.getShort("MINIMUM_SCALE"));
            model.maximumScale = getRs(rs , () -> rs.getShort("MAXIMUM_SCALE"));
            model.numPrecRadix = getRs(rs , () -> rs.getInt("NUM_PREC_RADIX"));
            return model;
        });
    }
}
