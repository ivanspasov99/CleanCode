package bg.sofia.uni.fmi.jira.issues;

import components.Component;
import bg.sofia.uni.fmi.jira.User;
import issue.properties.IssuePriority;
import issue.properties.IssueType;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidReporterException;

import java.time.LocalDateTime;

public class NewFeature extends ScheduledIssue {
    private static final IssueType type = IssueType.NEW_FEATURE;

    public NewFeature(IssuePriority priority, Component component, User reporter, String description, LocalDateTime dueTime) throws InvalidReporterException {
        super(priority, component, reporter, description, dueTime);
    }

    @Override
    public IssueType getType() {
        return type;
    }
}
