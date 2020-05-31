
import static org.junit.Assert.assertEquals;


import exceptions.InvalidReporterException;

import interfaces.IssueTracker;

import issue.properties.IssueStatus;
import issues.Bug;
import issues.Issue;

import jira.Jira;

import org.junit.BeforeClass;
import org.junit.Test;

import components.Component;

import issue.properties.IssuePriority;
import issue.properties.IssueResolution;
import issue.properties.IssueType;

import users.*;
import users.enums.DeveloperJobPosition;
import users.enums.TesterType;
import users.enums.User;


import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class IssuesTrackerTest {

	private static List<Issue> issues;

	private static IssueTracker issueTracker;

	private static User reporter;

	private static User developer;

	private static Component component;

	@BeforeClass
	public static void setUp() throws InvalidReporterException, IllegalArgumentException {

		issues = new ArrayList<>();

		reporter = new Tester("Ivan", "Bulgaria", "Sega", TesterType.QUALITY);
		developer = new Developer("Pesho", "Bulgaria", "SAP", DeveloperJobPosition.MID, "Java, JS");
		component = new Component("Component-Pesho", "CP", developer);

		issues.add(new Bug(IssuePriority.MAJOR, component, reporter, "Big Bug"));
		//issues.add(new Task(IssuePriority.TRIVIAL, component, firstUser, "Fix UI component", LocalDateTime.now()));
		//issues.add(new Task(IssuePriority.TRIVIAL, component, firstUser, "Fix Back And component", LocalDateTime.now().plusDays(20)));

		issues.get(0).setStatus(IssueStatus.IN_PROGRESS);

		issueTracker = new Jira(issues);
	}

	@Test
	public void testFindAllIssuesBetweenDatesShouldReturnThreeRecords() {
		List<Issue> result = issueTracker.findAllIssuesCreatedBetween(LocalDateTime.now().minusDays(1),LocalDateTime.now().plusDays(1));

		assertEquals(3, result.size());
	}

	@Test
	public void testFindAllIssuesCreatedBeforeDateShouldReturnEmptyList() {
		List<Issue> result = issueTracker.findAllCreatedBeforeDate(LocalDateTime.now().minusDays(5));

		assertEquals(0, result.size());
	}

	@Test
	public void testFindAllIssuesCreatedBeforeDateShouldReturnThreeRecords() {
		List<Issue> result  = issueTracker.findAllCreatedBeforeDate(LocalDateTime.now().plusDays(15));

		assertEquals(3, result.size());
	}

	@Test
	public void testFindAllIssuesByStatusShouldReturnEmptyList() {
		List<Issue> result = issueTracker.findAllByStatus(component, IssueStatus.RESOLVED);

		assertEquals(0, result.size());
	}

	@Test
	public void testFindAllIssuesByResolutionShouldReturnThreeRecords() {
		List<Issue>  result= issueTracker.findAllByResolution(component, IssueResolution.UNRESOLVED);

		assertEquals(3, result.size());
	}

	@Test
	public void testFindAllIssuesByTypeShouldReturnTwoRecords() {
		List<Issue> result= issueTracker.findAllByType(component, IssueType.TASK);

		assertEquals(2, result.size());
	}

	@Test
	public void testFindAllIssuesByPriorityShouldReturnTwoRecords() {
		List<Issue>  result= issueTracker.findAllByPriority(component, IssuePriority.TRIVIAL);

		assertEquals(2, result.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatesNewComponentShouldThrowIllegalArgumentException() {
		Component component = new Component("test", "t", null);
	}
}
