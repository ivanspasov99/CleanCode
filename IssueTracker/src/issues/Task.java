package bg.sofia.uni.fmi.jira.issues;

import components.Component;
import bg.sofia.uni.fmi.jira.User;
import issue.properties.IssuePriority;
import issue.properties.IssueType;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidReporterException;

import java.time.LocalDateTime;

public class Task extends ScheduledIssue {
    private final static IssueType type = IssueType.TASK;

    public Task(IssuePriority priority, Component component, User reporter, String description, LocalDateTime dueTime) throws InvalidReporterException {
        super(priority, component, reporter, description, dueTime);
    }

    @Override
    public IssueType getType() {
        return type;
    }
}
