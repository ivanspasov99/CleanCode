package issues;

import components.Component;

import exceptions.InvalidReporterException;

import generators.IdGenerator;
import issue.properties.IssuePriority;
import issue.properties.IssueResolution;
import issue.properties.IssueStatus;

import interfaces.IIssue;

import validators.Validator;

import java.time.LocalDateTime;


// ideas
// we could add people management
// with reported, developer (assignTo), review (manager, which will assign to )


public abstract class Issue implements IIssue {
    // we can make separate class for issue properties
    private IssuePriority priority;
    private IssueStatus status = IssueStatus.OPEN;
    private IssueResolution resolution = IssueResolution.UNRESOLVED;

    private Component component;

    private final String ID;
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    Issue(IssuePriority priority, Component component, String description) throws InvalidReporterException, IllegalArgumentException {

        Validator.validateNullValues(priority, component, description);

        initIssueProperties(priority);

        this.component = component;

        this.description = description;

        this.ID = component.getAbbreviation() + IdGenerator.generateUniqueId();

        initDateProperties();
    }

    private void initIssueProperties(IssuePriority priority) {
        this.priority = priority;
        this.status = IssueStatus.OPEN;
        this.resolution = IssueResolution.UNRESOLVED;
    }

    private void initDateProperties() {
        createdAt = LocalDateTime.now();
        updatedAt = null;
    }

    @Override
    public void setResolution(IssueResolution resolution) {
        this.resolution = resolution;
    }
    @Override
    public void setStatus(IssueStatus status) {
        this.status = status;
    }
    @Override
    public void setPriority(IssuePriority priority) {
        this.priority = priority;
    }

    @Override
    public String getId() {
        return ID;
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Component getComponent() {
        return component;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    @Override
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public IssuePriority getPriority() {
        return priority;
    }
    public IssueStatus getStatus() {
        return status;
    }
    public IssueResolution getResolution() {
        return resolution;
    }
}
