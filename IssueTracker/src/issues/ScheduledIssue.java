package issues;

import components.Component;

import exceptions.DeveloperNotAssignException;
import exceptions.InvalidReporterException;
import exceptions.PermissionDeniedException;

import issue.properties.IssuePriority;

import users.Developer;
import users.Manager;

import validators.Validator;

import java.time.LocalDateTime;

public abstract class ScheduledIssue extends Issue {

    private final LocalDateTime dueTime;

    Manager manager;
    Developer developer;

    public ScheduledIssue(IssuePriority priority, Component component, Manager manager, String description, LocalDateTime dueTime) throws InvalidReporterException, IllegalArgumentException {

        super(priority, component, description);

        Validator.validateNullValues(dueTime, manager);

        this.developer = null;
        this.manager = manager;

        this.dueTime = dueTime;
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }

    public void assignDeveloper(Developer dev, Manager manager) throws PermissionDeniedException {

        if(!this.manager.getName().equals(manager.getName())) {
            throw new PermissionDeniedException("You are not the manager who created the issue. Permission Denied");
        }

        developer = dev;
    }

    public boolean isAssigned() {
        return developer == null;
    }

    public Manager getManager() {
        return manager;
    }

    public Developer getDeveloper() throws DeveloperNotAssignException {

        if(developer == null) {
            throw new DeveloperNotAssignException("There is not assigned Developer to this task yet");
        }

        return developer;
    }
}
