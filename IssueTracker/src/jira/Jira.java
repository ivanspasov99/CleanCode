package jira;

import components.Component;

import interfaces.IssueTracker;

import issues.Issue;

import issue.properties.IssuePriority;
import issue.properties.IssueResolution;
import issue.properties.IssueStatus;
import issue.properties.IssueType;

import validators.Validator;

import java.time.LocalDateTime;

import java.util.List;
import java.util.ArrayList;

public class Jira implements IssueTracker {

    private List<Issue> issues;

    JiraFiltration jiraFiltration;

    public Jira(List<Issue> issues) {
        // assert there is no null values in issues
        Validator.validateNullValues(issues);

        this.issues = issues;

        JiraFiltration jiraFiltration = new JiraFiltration();
    }

    public Jira() {
        issues = new ArrayList<>();
    }

    @Override
    public List<Issue> findAllByStatus(Component component, IssueStatus status) {
        return jiraFiltration.findAllByStatus(issues, component, status);
    }

    @Override
    public List<Issue> findAllByPriority(Component component, IssuePriority priority) {
        return jiraFiltration.findAllByPriority(issues, component, priority);
    }

    @Override
    public List<Issue> findAllByType(Component component, IssueType type) {
        return jiraFiltration.findAllByType(issues, component, type);
    }

    @Override
    public List<Issue> findAllByResolution(Component component, IssueResolution resolution) {
        return jiraFiltration.findAllByResolution(issues, component, resolution);
    }

    @Override
    public List<Issue> findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime) {
       return jiraFiltration.findAllIssuesCreatedBetween(issues, startTime, endTime);
    }

    @Override
    public List<Issue> findAllCreatedBeforeDate(LocalDateTime dueTime) {
        return jiraFiltration.findAllCreatedBeforeDate(issues, dueTime);
    }

}
