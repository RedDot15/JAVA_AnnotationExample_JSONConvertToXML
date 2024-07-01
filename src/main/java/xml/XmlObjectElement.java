package xml;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlObjectElement {
    String name();
}
