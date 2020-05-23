package interfaces;

import components.Component;
import issue.properties.IssuePriority;
import issue.properties.IssueResolution;
import issue.properties.IssueStatus;
import issue.properties.IssueType;
import issues.Issue;

import java.time.LocalDateTime;

public interface IssueTracker {
    Issue[] findAll(Component component, IssueStatus status);
    Issue[] findAll(Component component, IssuePriority priority);
    Issue[] findAll(Component component, IssueType type);
    Issue[] findAll(Component component, IssueResolution resolution);
    Issue[] findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime);
    Issue[] findAllBefore(LocalDateTime dueTime);
}
