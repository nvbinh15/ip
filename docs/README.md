# User Guide

## Table of Contents
1. [Introduction](#1-introduction)
1. [Quick Start](#2-quick-start)
1. [Features](#3-features)\
3.1. [Adding A Task: `todo`, `deadline`, `event`](#31-adding-a-task-todo-deadline-event)\
3.2. [Listing Tasks: `list`](#32-listing-tasks-list)\
3.3. [Marking A Task As Done: `done`](#33-marking-a-task-as-done-done)\
3.4. [Deleting A Task: `delete`](#34-deleting-a-task-delete)\
3.5. [Finding Tasks: `find`](#35-finding-tasks-find)\
3.6. [Exiting Duke: `bye`](#36-exiting-duke-bye)
1. [Command Summary](#4-command-summary)
1. [FAQ](#5-faq)

## 1. Introduction

## 2. Quick Start

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `duke.jar` from [here]().
3. Copy the file to the folder you want to use as the _home folder_ for Duke.
4. In the home folder for Duke, launch the `jar` file using the `java -jar duke.jar` command on Command Prompt (for Windows) or Terminal (for Unix-based OS, such as macOS and Linux) to start the app. If the setup is correct, you should see some think like this:

```
	__________________________________________________
	 ____        _
	|  _ \ _   _| | _____
	| | | | | | | |/ / _ \
	| |_| | |_| |   <  __/
	|____/ \__,_|_|\_\___|

	Hello! I'm Duke
	What can I do for you?
	__________________________________________________
```

5. Type the valid command into the terminal (or Command Prompt) and press <kbd>Enter</kbd> to run the command.

    Example: Typing `list` command and pressing <kbd>Enter</kbd> will list all the tasks added to Duke.

## 3. Features

:information_source: **Notes about the command format:**

- Words in `UPPER_CASE` are the parameters to be supplied by the user.
- The `INDEX`
 used in various commands is a number specifying the order of a task in the list of tasks (1-based). This number can be found on the left of a task after running the `list` command.
- `DATE` that you input to Duke should follow the `DD-MM-YYYY` format./
Example: `01/01/2021` represents the date 1 January 2021.
- `TIME` that you input to Duke should follow the `HHMM` format where `HH` is the hour (0-23) and `MM` is the minute in the hour (0-59).
Example: `1800` represents the time 6:00pm.
- Parameters cannot be reordered.
Example: If the command specifies `event DESCRIPTION /at DATE TIME`, keying in `event /at DATE TIME DESCRIPTION` will result in an invalid command.

### 3.1. Adding A Task: `todo`, `deadline`, `event`


### 3.2. Listing Tasks: `list`

Lists all tasks in Duke with numbering according to the order they are added (1-based index).

Format: `list`

Expected output:

```
	__________________________________________________
	Here are the tasks in your list:
	1. [E][ ] liverpool match (at: Sep 25 2021 21:00)
	2. [T][ ] ip level-8
	3. [D][X] moreOOP (by: Oct 01 2021 23:59)
	4. [D][ ] submit final version ip (by: Oct 01 2021 23:59)
	__________________________________________________
```

### 3.3. Marking A Task As Done: `done`

Marks a task as done.

Format: `done INDEX`

Example: `done 2`

Expected output:

```
	__________________________________________________
	Nice! I've marked this task as done:
		[T][X] ip level-8
	__________________________________________________
```

### 3.4. Deleting A Task: `delete`

Deletes the specified task from the tasks list.

Format: `delete INDEX`

Example: `delete 2`

Expected outcome:

```
	__________________________________________________
	Noted. I've removed this task:
		[T][X] ip level-8
	Now you have 3 tasks in the list.
	__________________________________________________
```


### 3.5. Finding Tasks: `find`

Finds that tasks of which description contains any of the given keywords.

Format: `find KEYWORD`

Example: `find ip`

Expected outcome:

```
	__________________________________________________
	Here are the matching tasks in your list:
	1. [T][X] ip level-8
	2. [D][ ] submit final version ip (by: Oct 01 2021 23:59)
	__________________________________________________
```


### 3.6. Exiting Duke: `bye`

Exits the program.

Format: `exit`

Expected outcome:

```
	__________________________________________________
	Bye. Hope to see you again soon!
	__________________________________________________
```

## 4. Command Summary

**Action** | **Format, Examples**
|----------|---------------------|
**Add**|- `todo DESCRIPTION`</br> Example: `todo drink water`</br>- `deadline DESCRIPTION /by DATE TIME`</br> Example: `deadline iP user guide /by 01-10-2021 2359`</br>- `event DESCRIPTION /at DATE TIME`</br> Example: `event CS2113 team meeting /at 27-09-2021 1400`
**List**|`list`
**Mark As Done**|`done INDEX`</br> Example: `done 2`
**Delete**|`delete INDEX`</br> Example: `delete 1`
**Find**|`find KEYWORD`</br> Example: `find CS2113`
**Exit**|`bye`

## 5. FAQ

Below are the answers to some of frequently askes questions about Duke.

**Q:** Can I use Duke on different operating systems such as Windows and macOS?\
**A:** Yes. Duke is compatible with Windows, macOS, and Linus as long as you have Java `11` or above installed in your machine.

**Q:** What will happen to my data if Duke crashed?\
**A:** Data is saved automatically to `data/duke.txt` whenever you change your tasks. Therefore, your data will be safely saved even though Duke is crashed.

**Q:** Can I exit Duke without using the `bye` command?\
**A:** Yes, you can. As mentioned above, your data will be saved automatically if a change of the tasks occurs, so you can exit Duke worry-free.
