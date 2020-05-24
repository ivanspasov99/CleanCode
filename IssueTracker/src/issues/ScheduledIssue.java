package issues;


import components.Component;

import exceptions.InvalidReporterException;

import issue.properties.IssuePriority;

import users.User;

import validators.Validator;

import java.time.LocalDateTime;

public abstract class ScheduledIssue extends Issue {

    private final LocalDateTime dueTime;

    public ScheduledIssue(IssuePriority priority, Component component, User reporter, String description, LocalDateTime dueTime) throws InvalidReporterException, IllegalArgumentException {

        super(priority, component, reporter, description);

        Validator.validateNullValues(dueTime);

        this.dueTime = dueTime;
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }

}
