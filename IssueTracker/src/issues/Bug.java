package issues;

import components.Component;

import exceptions.InvalidReporterException;

import issue.properties.IssuePriority;
import issue.properties.IssueType;

import users.Tester;

public class Bug extends Issue {

    private final IssueType TYPE = IssueType.BUG;

    private Tester reporter;

    public Bug(IssuePriority priority, Component component, Tester reporter, String description) throws InvalidReporterException {

        super(priority, component, description);

        this.reporter = reporter;

    }

    @Override
    public IssueType getType() {
        return TYPE;
    }

    public Tester getReporter() {
        return reporter;
    }

}
