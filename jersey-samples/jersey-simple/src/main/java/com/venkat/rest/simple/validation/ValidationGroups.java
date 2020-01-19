package com.venkat.rest.simple.validation;

import javax.validation.groups.Default;

public final class ValidationGroups {

    private ValidationGroups() { }

    public static interface CreateOperation extends Default { }
    public static interface PatchOperation extends Default { }
    public static interface UpdateOperation extends Default { }

}
