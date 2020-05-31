package issues;

import components.Component;

import exceptions.InvalidReporterException;

import issue.properties.IssuePriority;
import issue.properties.IssueType;

import users.Developer;
import users.Manager;

import validators.Validator;

import java.time.LocalDateTime;

public class Task extends ScheduledIssue {

    private final IssueType TYPE = IssueType.TASK;

    private Developer developer;
    private Bug currentBug;

    public Task(IssuePriority priority, Component component, Bug bug, Manager manager, String description, LocalDateTime dueTime) throws InvalidReporterException {

        super(priority, component, manager, description, dueTime);

        Validator.validateNullValues(bug);

        currentBug = bug;
        developer = null;
    }

    @Override
    public IssueType getType() {
        return TYPE;
    }


}
