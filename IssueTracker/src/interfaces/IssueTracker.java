package interfaces;

import components.Component;

import issue.properties.IssuePriority;
import issue.properties.IssueResolution;
import issue.properties.IssueStatus;
import issue.properties.IssueType;

import issues.Issue;

import java.time.LocalDateTime;

public interface IssueTracker {

    Issue[] findAllByStatus(Component component, IssueStatus status);
    Issue[] findAllByPriority(Component component, IssuePriority priority);
    Issue[] findAllByType(Component component, IssueType type);
    Issue[] findAllByResolution(Component component, IssueResolution resolution);

    Issue[] findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime);
    Issue[] findAllBeforeDate(LocalDateTime dueTime);

}
