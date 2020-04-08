package com.tutal.wordik.repo;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

public class NamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalTableName(lowerCase(name), context);
    }

    private Identifier lowerCase(Identifier name) {
        if (name == null)
            return null;
        if (name.isQuoted())
            return name;
        String text = name.getText().toLowerCase(Locale.forLanguageTag("en"));
        return Identifier.toIdentifier(text);
    }
}
