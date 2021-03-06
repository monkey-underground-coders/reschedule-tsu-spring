package com.a6raywa1cher.rescheduletsuspring.models;

import com.a6raywa1cher.rescheduletsuspring.externalmodels.Direction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "lesson_cell", indexes = {
	@Index(columnList = "faculty,group", name = "Get_for_group")
})
@EqualsAndHashCode(exclude = "creator")
@ToString(exclude = "creator")
public class LessonCell implements LessonCellInfoHolder {
	@Id
	private String externalId;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private WeekSign weekSign;

	@Column
	private String fullSubjectName;

	@Column
	private String shortSubjectName;

	@Column
	private String teacherName;

	@Column
	private String teacherTitle;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private DayOfWeek dayOfWeek;

	@Column
	private Integer columnPosition;

	@Column
	private LocalTime start;

	@Column(name = "\"end\"")
	private LocalTime end;

	@Column
	private String auditoryAddress;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private Direction.Level level;

	@Column
	private Integer course;

	@Column(name = "\"group\"")
	private String group;

	@Column
	private Integer subgroup;

	@Column
	private Integer countOfSubgroups;

	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean crossPair;

	@Column(nullable = false)
	private String faculty;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> attributes = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	private User creator;

	@Column
	private Boolean ignoreExternalDb;

	@Column
	private String ignoreExternalDbHashCode;
}
