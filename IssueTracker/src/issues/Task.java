package issues;

import components.Component;

import exceptions.InvalidReporterException;

import issue.properties.IssuePriority;
import issue.properties.IssueType;

import users.Developer;



import java.time.LocalDateTime;

public class Task extends ScheduledIssue {
    // must be assigned in the beginning
    // we do not need reporter here
    private final IssueType TYPE = IssueType.TASK;

    private Developer developer;

    private Bug currentBug;

    public Task(IssuePriority priority, Component component, String description, LocalDateTime dueTime) throws InvalidReporterException {

        super(priority, component, description, dueTime);

    }

    @Override
    public IssueType getType() {
        return TYPE;
    }

}
