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
    // we can do some operations with issues
    // slower than issue[] class implementation
    private List<Issue> issues;

    public Jira(List<Issue> issues) {
        Validator.validateNullValues(issues);

        this.issues = issues;
    }

    public Jira() {
        issues = new ArrayList<>();
    }

    @Override
    public List<Issue> findAllByStatus(Component component, IssueStatus status) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: this.issues) {
            if(isComponentEqual(issue, component) && issue.getStatus() == status) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    @Override
    public List<Issue> findAllByPriority(Component component, IssuePriority priority) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: this.issues) {
            if(isComponentEqual(issue, component) && issue.getPriority() == priority) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    @Override
    public List<Issue> findAllByType(Component component, IssueType type) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: this.issues) {
            if(isComponentEqual(issue, component) && issue.getType() == type) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    @Override
    public List<Issue> findAllByResolution(Component component, IssueResolution resolution) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: this.issues) {
            if(isComponentEqual(issue, component) && issue.getResolution() == resolution) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    @Override
    public List<Issue> findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: this.issues) {
            if(isBetweenDates(issue, startTime, endTime)) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    @Override
    public List<Issue> findAllBeforeDate(LocalDateTime dueTime) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: this.issues) {
            if(issue.getCreatedAt().isBefore(dueTime)) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    private boolean isComponentEqual(Issue currentIssue, Component component) {
        String issueComponentName = currentIssue.getComponent().getName();

        return issueComponentName.equals(component.getName());
    }
    private boolean isBetweenDates(Issue issue, LocalDateTime startDate, LocalDateTime endDate) {
        LocalDateTime createdAt = issue.getCreatedAt();

        return createdAt.isAfter(startDate) && createdAt.isBefore(endDate);
    }
}
