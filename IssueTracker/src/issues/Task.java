package issues;

import components.Component;

import exceptions.InvalidReporterException;
import issue.properties.IssuePriority;
import issue.properties.IssueType;
import users.User;


import java.time.LocalDateTime;

public class Task extends ScheduledIssue {
    // must be assigned in the beginning
    // we do not need reporter here
    private final IssueType TYPE = IssueType.TASK;

    public Task(IssuePriority priority, Component component, User reporter, String description, LocalDateTime dueTime) throws InvalidReporterException {

        super(priority, component, reporter, description, dueTime);

    }

    @Override
    public IssueType getType() {
        return TYPE;
    }

}
