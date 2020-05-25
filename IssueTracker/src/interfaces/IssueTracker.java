package interfaces;

import components.Component;

import issue.properties.IssuePriority;
import issue.properties.IssueResolution;
import issue.properties.IssueStatus;
import issue.properties.IssueType;

import issues.Issue;

import java.time.LocalDateTime;
import java.util.List;

public interface IssueTracker {

    List<Issue> findAllByStatus(Component component, IssueStatus status);
    List<Issue> findAllByPriority(Component component, IssuePriority priority);
    List<Issue> findAllByType(Component component, IssueType type);
    List<Issue> findAllByResolution(Component component, IssueResolution resolution);

    List<Issue> findAllIssuesCreatedBetween(LocalDateTime startTime, LocalDateTime endTime);
    List<Issue> findAllCreatedBeforeDate(LocalDateTime dueTime);

}
