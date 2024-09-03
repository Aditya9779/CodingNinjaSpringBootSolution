package org.assisment.studentHibernative;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // This annotation can only be applied to classes
@Retention(RetentionPolicy.RUNTIME) // The annotation will be available at runtime
public @interface Author {
    String name();

    String date();
}


