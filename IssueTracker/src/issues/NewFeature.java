package issues;

import components.Component;

import exceptions.InvalidReporterException;

import issue.properties.IssuePriority;
import issue.properties.IssueType;

import users.Manager;

import java.time.LocalDateTime;

public class NewFeature extends ScheduledIssue {
    private final IssueType TYPE = IssueType.NEW_FEATURE;

    public NewFeature(IssuePriority priority, Component component, Manager manager, String description, LocalDateTime dueTime) throws InvalidReporterException {

        super(priority, component, manager,description, dueTime);

    }

    @Override
    public IssueType getType() {
        return TYPE;
    }
}
