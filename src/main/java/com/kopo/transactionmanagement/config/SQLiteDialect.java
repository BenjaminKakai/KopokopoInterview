package com.kopo.transactionmanagement.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
        // Assuming JDBC type -2 corresponds to VARBINARY or similar
        registerColumnType(-2, "blob");
    }

    @Override
    public String getAddColumnString() {
        // Basic support for adding a column, SQLite supports this operation.
        return "add column";
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl();
    }

    @Override
    public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
        if (sqlTypeDescriptor.getSqlType() == java.sql.Types.BLOB) {
            // Remap BLOB to binary
            return BinaryTypeDescriptor.INSTANCE;
        }
        return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
    }

    // Include other necessary overrides and customizations
}
