package issues;

import components.Component;

import exceptions.InvalidReporterException;

import issue.properties.IssuePriority;
import issue.properties.IssueType;

import users.User;

import java.time.LocalDateTime;

public class NewFeature extends ScheduledIssue {
    // here it is not gonna be assign, waiting for manager
    private static final IssueType TYPE = IssueType.NEW_FEATURE;

    public NewFeature(IssuePriority priority, Component component, User reporter, String description, LocalDateTime dueTime) throws InvalidReporterException {
        super(priority, component, reporter, description, dueTime);

    }
}
