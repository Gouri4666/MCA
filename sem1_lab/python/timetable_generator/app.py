from flask import Flask, render_template, request
import random

app = Flask(__name__)

@app.route("/")
def home():
    return render_template("index.html")


@app.route("/create-timetable", methods=["GET", "POST"])
def create_timetable():
    if request.method == "POST":

        total_hours_per_day = int(request.form["hours_per_day"])
        number_of_subjects = int(request.form["num_subjects"])

        subject_names = request.form.getlist("subject_name[]")
        subject_hours = request.form.getlist("subject_hours[]")

        subjects = []
        for name, hours in zip(subject_names, subject_hours):
            subjects.append({"name": name, "hours": int(hours)})

        # Monday to Friday (Fixed)
        working_days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]

        # Create empty timetable grid
        timetable = {day: [""] * total_hours_per_day for day in working_days}

        # Fill the minimum required hours
        for subject in subjects:
            assigned = 0
            while assigned < subject["hours"]:
                day = random.choice(working_days)
                hour = random.randint(0, total_hours_per_day - 1)

                if timetable[day][hour] == "":
                    timetable[day][hour] = subject["name"]
                    assigned += 1

        # Fill remaining empty hours randomly
        subject_list = [sub["name"] for sub in subjects]

        for day in working_days:
            for hour in range(total_hours_per_day):
                if timetable[day][hour] == "":
                    timetable[day][hour] = random.choice(subject_list)

        return render_template(
            "display.html",
            timetable=timetable,
            working_days=working_days,
            hours_per_day=total_hours_per_day
        )

    return render_template("create_timetable.html")


if __name__ == "__main__":
    app.run(debug=True)
