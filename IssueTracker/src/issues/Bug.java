package issues;

import components.Component;
import bg.sofia.uni.fmi.jira.User;
import issue.properties.IssuePriority;
import issue.properties.IssueType;
import bg.sofia.uni.fmi.jira.issues.exceptions.InvalidReporterException;

public class Bug extends Issue {
    private static final IssueType type = IssueType.BUG;

    public Bug(IssuePriority priority, Component component, User reporter, String description) throws InvalidReporterException {
        super(priority, component, reporter, description);
    }

    @Override
    public IssueType getType() {
        return type;
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
