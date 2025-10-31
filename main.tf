provider "google" {
    project = "pranay-476112"
    region = "us-central1"
}

resource "google_compute_instance" "tf_vm1" {
    name = "jenkins-usecase"
    machine_type = "e2-medium"
    zone = "us-central1-a"
    boot_disk {
      initialize_params {
        image = "ubuntu-os-cloud/ubuntu-2204-lts"
      }
    }
    network_interface {
      network = "default"
      access_config {
      }
    }
  metadata_startup_script = file("./startup-script.sh")
}
