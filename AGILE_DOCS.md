# Agile Documentation: Smart Procurement Vendor Management System

This document outlines the Agile methodology, ceremonies, and artifacts used in the development of the Smart Procurement Vendor Management System.

## 1. Product Vision

To build a streamlined, intelligent procurement and vendor management platform that simplifies vendor onboarding, automates procurement workflows, and provides actionable insights into vendor performance.

## 2. Roles

*   **Product Owner**: Responsible for prioritizing the Product Backlog and ensuring the team delivers value.
*   **Scrum Master**: Facilitates Agile ceremonies, removes impediments, and ensures the team follows Agile practices.
*   **Development Team**: Cross-functional team responsible for delivering potentially shippable product increments at the end of each Sprint.

## 3. Agile Ceremonies

*   **Sprint Planning**: Held at the beginning of each Sprint to determine which Product Backlog Items (PBIs) will be worked on.
*   **Daily Standup**: A 15-minute daily meeting for the Development Team to synchronize activities and create a plan for the next 24 hours. Questions answered:
    *   What did I do yesterday?
    *   What will I do today?
    *   Are there any blockers?
*   **Sprint Review**: Held at the end of the Sprint to inspect the Increment and adapt the Product Backlog if needed. Demonstrated completed features to stakeholders.
*   **Sprint Retrospective**: Held after the Sprint Review and prior to the next Sprint Planning to inspect how the last Sprint went (people, relationships, process, and tools) and identify improvements for the next one.

## 4. Artifacts

### Product Backlog

A prioritized list of everything that is known to be needed in the product.

**Epic 1: Vendor Management**
*   **User Story**: As an admin, I want to onboard new vendors so that they can start participating in the procurement process.
*   **User Story**: As an admin, I want to view a list of all active vendors and their performance ratings.
*   **User Story**: As a vendor, I want to update my profile information to keep my details current.

**Epic 2: Procurement Workflow**
*   **User Story**: As a purchaser, I want to create a purchase requisition so that I can request items.
*   **User Story**: As an approver, I want to review and approve/reject purchase requisitions.
*   **User Story**: As a system, I want to automatically generate purchase orders upon requisition approval.

### Sprint Backlog

The set of Product Backlog items selected for the current Sprint, plus a plan for delivering the product Increment and realizing the Sprint Goal.

### Definition of Done (DoD)

A shared understanding of what it means for work to be complete.
*   Code is written, reviewed, and merged.
*   Unit tests are written and passing.
*   Feature is deployed to the staging environment.
*   Acceptance criteria specified in user stories are met.
*   Documentation is updated.

## 5. Typical Sprint Schedule (2-Week Sprints)

*   **Week 1, Monday**: Sprint Planning (Define Sprint Goal & Backlog)
*   **Daily**: Standup (15 mins)
*   **Week 2, Thursday**: Code Freeze, Staging Deployment for final QA
*   **Week 2, Friday**: Sprint Review (Demo) & Sprint Retrospective
