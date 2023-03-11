
CREATE TABLE `class` (
  `id` int(11) NOT NULL,
  `section` int(40) NOT NULL,
  `teacher` int(18) NOT NULL,
  `subject` int(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `class` (`id`, `section`, `teacher`, `subject`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 2),
(3, 3, 3, 3);

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `class` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `student` (`id`, `name`, `surname`, `age`, `class`) VALUES
(1, 'James', 'Smith', 22, 1),
(2, 'Robert', 'Brown', 22, 1),
(4, 'Richard', 'Jones', 21, 3),
(5, 'Andrew', 'Miller', 19, 2),
(6, 'Andrea', 'Smith', 21, 2),
(7, 'Diana', 'Garcia', 22, 1);


CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `subject` (`id`, `name`, `description`) VALUES
(1, 'English', 'Phase 1'),
(2, 'History', 'Phase 1'),
(3, 'Mathematics', 'Phase 3');


CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `age` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `teacher` (`id`, `name`, `surname`, `age`) VALUES
(1, 'Stephen', 'Walker', '53'),
(2, 'Jonathan', 'Scott', '60'),
(3, 'Peter', 'Adams', '45');


ALTER TABLE `class`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subject_id` (`subject`),
  ADD KEY `teacher_id` (`teacher`);

  
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `class_id` (`class`);


  
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

  
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `class`
  ADD CONSTRAINT `subject_id` FOREIGN KEY (`subject`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `teacher_id` FOREIGN KEY (`teacher`) REFERENCES `teacher` (`id`);


ALTER TABLE `student`
  ADD CONSTRAINT `class_id` FOREIGN KEY (`class`) REFERENCES `class` (`id`);

