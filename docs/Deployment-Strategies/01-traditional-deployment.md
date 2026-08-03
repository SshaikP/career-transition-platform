# 🚀 Phase 1 – Traditional Deployment
2
 
3
## 📖 Overview
4
 
5
This document describes the initial deployment architecture of **SkillOrbit** before introducing containerization and cloud-native deployment techniques.
6
 
7
In this phase, the application components run directly on the host machine:
8
 
9
- React Frontend
10
- Spring Boot Backend
11
- H2 Database
12
 
13
This deployment model was used to validate the application's core functionality, authentication mechanisms, role management, skill analysis engine, and learning roadmap generation.
14
 
15
---
16
 
17
# 🎯 Objectives
18
 
19
The primary objectives of this deployment phase were:
20
 
21
✅ Develop the MVP
22
 
23
✅ Validate frontend-backend communication
24
 
25
✅ Implement JWT authentication
26
 
27
✅ Implement Role-Based Access Control (RBAC)
28
 
29
✅ Build the Skill Gap Analysis Engine
30
 
31
✅ Establish foundational architecture
32
 
33
---
34
 
35
# 🏗️ Traditional Architecture
36
 
37
```text
38
+-------------------+
39
| Browser |
40
+---------+---------+
41
|
42
| HTTP
43
v
44
+-------------------+
45
| React Frontend |
46
| localhost:3000 |
47
+---------+---------+
48
|
49
| REST API Calls
50
|
51
v
52
+-------------------+
53
| Spring Boot APIs |
54
| localhost:8080 |
55
+---------+---------+
56
|
57
| JPA
58
|
59
v
60
+-------------------+
61
| H2 Database |
62
| In-Memory DB |
63
+-------------------+
64
```
65
 
66
---
67
 
68
# 🌐 Network Flow
69
 
70
```mermaid
71
flowchart LR
72
 
73
U[User Browser]
74
 
75
F[React Frontend<br/>localhost:3000]
76
 
77
B[Spring Boot Backend<br/>localhost:8080]
78
 
79
D[(H2 Database)]
80
 
81
U --> F
82
 
83
F -->|REST API Calls| B
84
 
85
B -->|CRUD Operations| D
86
 
87
D --> B
88
 
89
B --> F
90
 
91
F --> U
92
```
93
 
94
---
95
 
96
# 🔄 Application Request Flow
97
 
98
```mermaid
99
sequenceDiagram
100
 
101
actor User
102
 
103
participant Frontend as React Frontend
104
participant Backend as Spring Boot API
105
participant DB as H2 Database
106
 
107
User->>Frontend: Login / Select Role
108
Frontend->>Backend: API Request
109
Backend->>DB: Fetch Data
110
DB-->>Backend: Response
111
Backend-->>Frontend: JSON Response
112
Frontend-->>User: Dashboard Update
113
```
114
 
115
---
116
 
117
# 🧩 Components
118
 
119
## Frontend
120
 
121
### Technology
122
 
123
- React.js
124
- JavaScript
125
- HTML
126
- CSS
127
 
128
### Responsibilities
129
 
130
- Login UI
131
- Admin Dashboard
132
- Skill Analysis Dashboard
133
- User Interaction Layer
134
- API Consumption
135
 
136
---
137
 
138
## Backend
139
 
140
### Technology
141
 
142
- Spring Boot
143
- Spring Security
144
- JWT Authentication
145
- Spring Data JPA
146
 
147
### Responsibilities
148
 
149
- Authentication
150
- Role Management
151
- Skill Management
152
- Roadmap Generation
153
- Gap Analysis Processing
154
 
155
---
156
 
157
## Database
158
 
159
### Technology
160
 
161
- H2 In-Memory Database
162
 
163
### Responsibilities
164
 
165
- User Data Storage
166
- Role Data Storage
167
- Skills Repository
168
- Roadmap Definitions
169
 
170
---
171
 
172
# 📦 Prerequisites
173
 
174
## Backend
175
 
176
- Java 17+
177
- Maven 3.9+
178
 
179
## Frontend
180
 
181
- Node.js
182
- npm
183
 
184
---
185
 
186
# ▶️ Backend Deployment
187
 
188
Navigate to backend folder:
189
 
190
```bash
191
cd user-service
192
```
193
 
194
Build application:
195
 
196
```bash
197
mvn clean install
198
```
199
 
200
Start application:
201
 
202
```bash
203
mvn spring-boot:run
204
```
205
 
206
Application URL:
207
 
208
```text
209
http://localhost:8080
210
```
211
 
212
---
213
 
214
# ▶️ Frontend Deployment
215
 
216
Navigate to frontend:
217
 
218
```bash
219
cd skillorbit-ui
220
```
221
 
222
Install dependencies:
223
 
224
```bash
225
npm install
226
```
227
 
228
Start application:
229
 
230
```bash
231
npm start
232
```
233
 
234
Application URL:
235
 
236
```text
237
http://localhost:3000
238
```
239
 
240
---
241
 
242
# 🔑 Authentication Flow
243
 
244
```mermaid
245
flowchart LR
246
 
247
U[User]
248
 
249
L[Login Page]
250
 
251
A[Authentication API]
252
 
253
J[JWT Token]
254
 
255
D[Dashboard]
256
 
257
U --> L
258
 
259
L --> A
260
 
261
A --> J
262
 
263
J --> D
264
```
265
 
266
---
267
 
268
# 📊 Skill Analysis Flow
269
 
270
```mermaid
271
flowchart TD
272
 
273
A[Select Target Role]
274
 
275
B[Load Required Skills]
276
 
277
C[Enter Skill Levels]
278
 
279
D[Submit Analysis]
280
 
281
E[Gap Calculation Engine]
282
 
283
F[Priority Assignment]
284
 
285
G[Roadmap Generation]
286
 
287
H[Analysis Result]
288
 
289
A --> B
290
 
291
B --> C
292
 
293
C --> D
294
 
295
D --> E
296
 
297
E --> F
298
 
299
F --> G
300
 
301
G --> H
302
```
303
 
304
---
305
 
306
# ⚠️ Challenges Encountered
307
 
308
## API Communication
309
 
310
### Challenge
311
 
312
Frontend and backend initially failed to communicate correctly due to API configuration issues.
313
 
314
### Resolution
315
 
316
- Standardized API endpoints
317
- Corrected request paths
318
- Improved response handling
319
 
320
---
321
 
322
## Authentication
323
 
324
### Challenge
325
 
326
JWT implementation required proper token propagation and authorization handling.
327
 
328
### Resolution
329
 
330
- Added JWT Filters
331
- Implemented Security Configuration
332
- Protected Admin APIs
333
 
334
---
335
 
336
## Data Consistency
337
 
338
### Challenge
339
 
340
Maintaining role-skill-roadmap relationships.
341
 
342
### Resolution
343
 
344
- Normalized data model
345
- Introduced clear entity relationships
346
 
347
---
348
 
349
# 📚 Key Learnings
350
 
351
During this phase, the following concepts were mastered:
352
 
353
- REST API Design
354
- JWT Authentication
355
- Spring Security
356
- Role-Based Authorization
357
- React State Management
358
- JPA Entity Relationships
359
- Full Stack Application Architecture
360
 
361
---
362
 
363
# ✅ Outcome
364
 
365
The traditional deployment phase successfully delivered:
366
 
367
- Secure Authentication
368
- Role-Based Access
369
- Dynamic User Interface
370
- Skill Gap Analysis
371
- Learning Roadmap Generation
372
 
373
This phase established the foundation for future deployment strategies:
374
 
375
➡️ Traditional Deployment
376
 
377
➡️ Containerized Deployment
378
 
379
➡️ Cloud Deployment
380
 
381
➡️ Kubernetes Orchestration
382
 
383
---
384
 
385
# 🚀 Next Phase
386
 
387
Continue to:
388
 
389
📄 02-containerized-deployment.md
390
 
391
to learn how SkillOrbit evolved into a Dockerized multi-container application.
