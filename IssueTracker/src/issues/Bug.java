package issues;

import components.Component;

import exceptions.InvalidReporterException;

import issue.properties.IssuePriority;
import issue.properties.IssueType;

import users.User;


public class Bug extends Issue {
    // we can add end date to fix
    // we can add developer to fix who will be assign by manager only...
    public static final IssueType TYPE = IssueType.BUG;

    public Bug(IssuePriority priority, Component component, User reporter, String description) throws InvalidReporterException {

        super(priority, component, reporter, description);

    }
}
