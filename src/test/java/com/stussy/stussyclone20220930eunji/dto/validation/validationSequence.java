package com.stussy.stussyclone20220930eunji.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;
import java.util.regex.Pattern;

@GroupSequence({ValidationGroups.NotBlankGroup.class,
                ValidationGroups.Size.class,
                ValidationGroups.PatternCheckGroup.class,
                Default.class
})
public interface validationSequence {}
