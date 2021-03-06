package interfaces;

import java.time.LocalDateTime;

import components.Component;

import issue.properties.IssuePriority;
import issue.properties.IssueResolution;
import issue.properties.IssueStatus;

import issue.properties.IssueType;


public interface IIssue {

    void setResolution(IssueResolution resolution);
    void setStatus(IssueStatus status);
    void setPriority(IssuePriority priority);

    String getId();
    String getDescription();

    Component getComponent();

    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    IssueType getType();

}
