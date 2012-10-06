package grails.buildtestdata.handler

import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.codehaus.groovy.grails.validation.Constraint
import org.codehaus.groovy.grails.validation.ConstrainedProperty
import org.codehaus.groovy.grails.plugins.testing.GrailsMockErrors

public class UniqueConstraintHandler implements ConstraintHandler {
    public void handle(domain, propertyName, appliedConstraint, constrainedProperty = null, circularCheckList = null) {
        // unique isn't supported, if the value we've got in there isn't valid by this point, throw an error letting
        // the user know why we're not passing
        if (appliedConstraint.unique && !constrainedProperty?.validate(domain, domain."$propertyName", new GrailsMockErrors(this))) {
            String error = "unique constraint support not implemented: property $propertyName of ${domain.class.name}" 
            throw new ConstraintHandlerException(error)
        }
    }
}