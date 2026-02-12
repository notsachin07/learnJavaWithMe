# Contributing to Java Learning Journey 🤝

First off, thank you for considering contributing to this project! 🎉

Every contribution helps make this a better resource for Java learners around the world.

---

## 📋 Table of Contents

- [Code of Conduct](#-code-of-conduct)
- [How Can I Contribute?](#-how-can-i-contribute)
- [Getting Started](#-getting-started)
- [Pull Request Process](#-pull-request-process)
- [Style Guidelines](#-style-guidelines)
- [Community](#-community)

---

## 📜 Code of Conduct

This project and everyone participating in it is governed by our commitment to providing a welcoming and inclusive environment. By participating, you are expected to:

- **Be respectful** - Treat everyone with respect and consideration
- **Be constructive** - Provide helpful feedback and suggestions
- **Be patient** - Remember that many learners are beginners
- **Be inclusive** - Welcome people of all backgrounds and skill levels

---

## 💡 How Can I Contribute?

### 🐛 Reporting Bugs

Found an error in the code or documentation? Please open an issue!

**Before submitting:**
1. Check if the issue already exists
2. Use a clear and descriptive title
3. Describe the exact steps to reproduce the problem
4. Include the expected vs actual behavior

**Bug Report Template:**
```markdown
**Description:**
A clear description of the bug.

**Location:**
Phase-X/ClassY/FileName.java (Line XX)

**Expected Behavior:**
What should happen.

**Actual Behavior:**
What actually happens.

**Steps to Reproduce:**
1. Step one
2. Step two
3. ...
```

### 💡 Suggesting Enhancements

Have an idea to improve the curriculum? We'd love to hear it!

- New exercise ideas
- Better explanations
- Additional examples
- New topics to cover

### 📝 Improving Documentation

Documentation improvements are always welcome:

- Fix typos or grammatical errors
- Clarify confusing explanations
- Add more examples
- Improve formatting

### 🧪 Adding Exercises

Want to add more practice problems? Great!

Each class should have exercises following this structure:
- **3 Easy** - Basic concept application
- **3 Medium** - Combining multiple concepts
- **3 Hard** - Complex real-world scenarios

### 🌍 Translations

Help make this resource accessible to non-English speakers by translating content.

---

## 🚀 Getting Started

### Prerequisites

- Git installed on your machine
- Java JDK 8 or higher
- A GitHub account

### Fork and Clone

1. **Fork** the repository on GitHub
2. **Clone** your fork locally:
   ```bash
   git clone https://github.com/YOUR-USERNAME/learnJavaWithMe.git
   cd learnJavaWithMe
   ```
3. **Add upstream** remote:
   ```bash
   git remote add upstream https://github.com/notsachin07/learnJavaWithMe.git
   ```

### Create a Branch

```bash
# Update your main branch
git checkout main
git pull upstream main

# Create a new branch for your feature
git checkout -b feature/your-feature-name
```

---

## 🔄 Pull Request Process

1. **Ensure your code works** - Test all Java files compile and run
2. **Follow the style guidelines** - See below
3. **Update documentation** - If you change functionality, update the README
4. **Write a clear PR description** - Explain what you changed and why

### PR Title Format

```
[Phase-X/ClassY] Brief description of change
```

Examples:
- `[Phase-1/Class2] Fix variable naming example`
- `[Phase-3/Class4] Add inheritance exercise`
- `[Docs] Update README badges`

### PR Description Template

```markdown
## Description
Brief description of changes made.

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Exercise addition
- [ ] Other (please describe)

## Checklist
- [ ] My code compiles without errors
- [ ] I have tested my changes
- [ ] I have updated relevant documentation
- [ ] My changes follow the project style guidelines
```

---

## 📏 Style Guidelines

### Java Code Style

```java
// ✅ Good: Clear class and method names
public class BankAccount {
    private double balance;
    
    public void deposit(double amount) {
        this.balance += amount;
    }
}

// ❌ Bad: Unclear naming
public class BA {
    private double b;
    
    public void d(double a) {
        this.b += a;
    }
}
```

**General Rules:**
- Use **camelCase** for variables and methods
- Use **PascalCase** for class names
- Use **UPPER_SNAKE_CASE** for constants
- Add comments explaining complex logic
- Keep methods focused and concise

### Documentation Style

- Use clear, simple language
- Explain concepts step by step
- Include sample output for all examples
- Use proper Markdown formatting
- Add emojis sparingly for visual appeal

### Commit Messages

```
type: brief description

Detailed explanation if needed.
```

Types:
- `feat:` - New feature
- `fix:` - Bug fix
- `docs:` - Documentation only
- `style:` - Formatting, no code change
- `refactor:` - Code restructuring
- `test:` - Adding tests

Examples:
```
feat: add polymorphism exercises

Added 9 new exercises covering:
- Method overriding
- Dynamic dispatch
- Abstract classes
```

---

## 👥 Community

### Getting Help

- Open an issue with your question
- Be patient - maintainers are volunteers
- Provide context about what you're trying to accomplish

### Recognition

All contributors will be:
- Listed in the README contributors section
- Thanked in release notes (for significant contributions)

---

## 🙏 Thank You!

Your contributions make a difference. Whether it's fixing a typo or adding a new phase, every bit helps learners on their Java journey.

**Happy Contributing! 🚀**

---

<div align="center">

[![GitHub issues](https://img.shields.io/github/issues/notsachin07/learnJavaWithMe?style=for-the-badge)](https://github.com/notsachin07/learnJavaWithMe/issues)
[![GitHub pull requests](https://img.shields.io/github/issues-pr/notsachin07/learnJavaWithMe?style=for-the-badge)](https://github.com/notsachin07/learnJavaWithMe/pulls)

</div>
