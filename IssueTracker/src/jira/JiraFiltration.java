package jira;

import components.Component;

import issue.properties.IssuePriority;
import issue.properties.IssueResolution;
import issue.properties.IssueStatus;
import issue.properties.IssueType;

import issues.Issue;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

class JiraFiltration {


    List<Issue> findAllByStatus(List<Issue> issues, Component component, IssueStatus status) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: issues) {
            if(isComponentEqual(issue, component) && issue.getStatus() == status) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    List<Issue> findAllByPriority(List<Issue> issues, Component component, IssuePriority priority) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: issues) {
            if(isComponentEqual(issue, component) && issue.getPriority() == priority) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    List<Issue> findAllByType(List<Issue> issues, Component component, IssueType type) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: issues) {
            if(isComponentEqual(issue, component) && issue.getType() == type) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    List<Issue> findAllByResolution(List<Issue> issues, Component component, IssueResolution resolution) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: issues) {
            if(isComponentEqual(issue, component) && issue.getResolution() == resolution) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    List<Issue> findAllIssuesCreatedBetween(List<Issue> issues, LocalDateTime startTime, LocalDateTime endTime) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: issues) {
            if(isBetweenDates(issue, startTime, endTime)) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }

    List<Issue> findAllCreatedBeforeDate(List<Issue> issues, LocalDateTime dueTime) {
        List<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue: issues) {
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
