package jira;

import interfaces.IssueTracker;
import issues.Issue;

import java.time.LocalDateTime;
import java.util.List;

public class Jira implements IssueTracker {
    // we can add Issues, to delete specific issues... etc
    private List<Issue> issues;

    public Jira(List<Issue> issues) {
        ValidateNullValues.validatePar(new Object[] { issues } ); // checking if issues at all is not null
        this.issues = issues;
    }

    public Jira() {
        // init empty list
    }

    @Override
    public Issue[] findAll(Component component, IssueStatus status) {
        int counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getComponent().getName().equals(component.getName()) && issues[i].getStatus() == status) {
                counter++;
            }
        }
        Issue[] filteredIssues = new Issue[counter];
        counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getComponent().getName().equals(component.getName()) && issues[i].getStatus() == status) {
                filteredIssues[counter++] = issues[i];
            }
        }
        return filteredIssues;
    }

    @Override
    public Issue[] findAll(Component component, IssuePriority priority) {
        int counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getComponent().getName().equals(component.getName()) && issues[i].getPriority() == priority) {
                counter++;
            }
        }
        Issue[] filteredIssues = new Issue[counter];
        counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getComponent().getName().equals(component.getName()) && issues[i].getPriority() == priority) {
                filteredIssues[counter++] = issues[i];
            }
        }
        return filteredIssues;
    }

    @Override
    public Issue[] findAll(Component component, IssueType type) {
        int counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if (issues[i] != null && issues[i].getComponent().getName().equals(component.getName()) && issues[i].getType() == type) {
                counter++;
            }
        }
        Issue[] filteredIssues = new Issue[counter];
        counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getComponent().getName().equals(component.getName()) && issues[i].getType() == type) {
                filteredIssues[counter++] = issues[i];
            }
        }
        return filteredIssues;
    }

    @Override
    public Issue[] findAll(Component component, IssueResolution resolution) {
        int counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getComponent().getName().equals(component.getName()) && issues[i].getResolution() == resolution) {
                counter++;
            }
        }
        Issue[] filteredIssues = new Issue[counter];
        counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getComponent().getName().equals(component.getName()) && issues[i].getResolution() == resolution) {
                filteredIssues[counter++] = issues[i];
            }
        }
        return filteredIssues;
    }

    @Override
    public Issue[] findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime) {
        int counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getCreatedAt().isAfter(startTime) && this.issues[i].getCreatedAt().isBefore(endTime)) {
                counter++;
            }
        }
        Issue[] filteredIssues = new Issue[counter];
        counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i] != null && issues[i].getCreatedAt().isAfter(startTime) && this.issues[i].getCreatedAt().isBefore(endTime)) {
                filteredIssues[counter++] = issues[i];
            }
        }
        return filteredIssues;
    }
    @Override
    public Issue[] findAllBefore(LocalDateTime dueTime) {
        int counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if(issues[i]!=null && !(issues[i] instanceof Bug)) {
                counter++;
            }
        }
        Issue[] filteredIssues = new Issue[counter];
        counter = 0;
        for (int i = 0; i < this.issues.length; i++) {
            if((issues[i] instanceof Bug) || issues[i] == null) {
                continue;
            }
            ScheduledIssue temp = (ScheduledIssue)issues[i];
            if(!(temp.getDueTime().isBefore(dueTime))) {
                continue;
            }
            filteredIssues[counter++] = temp;
        }
        return filteredIssues;
    }
}
