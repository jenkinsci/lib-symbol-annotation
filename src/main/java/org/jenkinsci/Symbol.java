package org.jenkinsci;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jvnet.hudson.annotation_indexer.Indexed;

/**
 * Defines a unique identifier to refer to an extension.
 *
 * <p>
 * This identifier is intended to be a short name that can be easily typed in by
 * humans, and be used by the likes of various DSL plugins and workflow which
 * uses text/code to refer to them.
 *
 * <p>
 * To keep symbol names short, symbol names are meant to be only unique within
 * a specific extension point. A symbol name shouldn't include the name of the
 * extension point in it (for example, "list" is preferred over "listView".)
 * A symbol name should follow the camel case convention, such as "fooBarZot"
 *
 * <p>
 * Because this is a short symbol, avoiding a collision requires a coordination.
 * We will scan the list of known symbol names in the update center and publish
 * that list to help people choose the symbol names wisely.
 *
 * <p>
 * The symbol must be a valid Java identifier. Multiple symbols can be specified as aliases.
 * The first one is used as the primary identifier for reverse-mapping.
 *
 * <p>
 * Generally symbols should be named after their display names, so that users see
 * association between what they see in web UI and symbols they see in code.
 *
 * <p>
 * To look up a component by its symbol, see the documentation of the symbol plugin.
 */
@Indexed
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Symbol {
    String[] value();
}
